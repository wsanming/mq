package com.goktech.olala.client.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.client.controller.basic.BasicController;
import com.goktech.olala.enums.RespCommCode;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.*;
import com.goktech.olala.core.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/sysAccountApi")
public class SysAccountController extends BasicController {

    @Autowired
    ISysUserService sysUserService;

    /**
     * 管理后台登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap login(HttpServletRequest request) throws Exception {

        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            String userName = params.getString("userName");
            String pwd = params.getString("pwd");
            ReqSysUser reqSysUser = new ReqSysUser();
            reqSysUser.setUserName(userName);
            reqSysUser.setPassword(pwd);
            RespUserVo respUserVo = sysUserService.querySysUserByExample(reqSysUser);
            if(respUserVo == null){
                respCode = SysConfig.ERROR_CODE;
                respMsg = "查询用户失败!";
            }else{
                //基于shiro实现登录
                Subject subject =  SecurityUtils.getSubject();
                //用户名和密码保存到token中
                AuthenticationToken token = new UsernamePasswordToken(respUserVo.getUserName(), respUserVo.getPassword());
                //如果正常登录,表示没有异常.登陆成功
                subject.login(token);
            }
            respData = super.respParamsFormat(respCode, respMsg, respUserVo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 管理后台退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginOut.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap loginOut(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        Subject subject =  SecurityUtils.getSubject();
        subject.logout();

        JSONObject respData = super.respParamsFormat(respCode, respMsg, null);
        resultMap.put("respData", respData);
        return resultMap;
    }

    /**
     * 管理后台切换账号
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/changeUser.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap changeUser(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        Subject subject =  SecurityUtils.getSubject();
        RespUserVo respUserVo = (RespUserVo)subject.getPrincipal();
        subject.logout();

        JSONObject respData = super.respParamsFormat(respCode, respMsg, respUserVo);
        resultMap.put("respData", respData);
        return resultMap;
    }

    /**
     * 初始化首页个人信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryIndexPersonInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap queryIndexPersonInfo(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        Subject subject =  SecurityUtils.getSubject();
        RespUserVo respUserVo = (RespUserVo)subject.getPrincipal();

        JSONObject respData = super.respParamsFormat(respCode, respMsg, respUserVo);
        resultMap.put("respData", respData);
        return resultMap;
    }

    /**
     * 登陆成功后初始化首页导航菜单列表信息
     *         ---二期待优化，此处的菜单权限列表建议放置本地缓存中
     *         ---shiro开启本地缓存
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/initMenuForIndex.do")
    @ResponseBody
    public ModelMap initMenuForIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            Subject subject = SecurityUtils.getSubject();
            RespUserVo respUserVo = (RespUserVo)subject.getPrincipal();
            List<RespSysMenuVo> respSysMenuVos = null;
            if(respUserVo.getRoleId() != null){
                respSysMenuVos = sysUserService.querySysMenusByRole(respUserVo.getRoleId());
            }
            respData = super.respParamsFormat(respCode, respMsg, respSysMenuVos);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 查询后台管理账号列表集合
     *
     * @param request
     * @param sEcho
     * @param iDisplayStart
     * @param iDisplayLength
     * @return
     */
    @RequestMapping(value = "/queryAccountList.do")
    @ResponseBody
    public ModelMap queryAccountList(HttpServletRequest request, Integer sEcho,
                                  Integer iDisplayStart, Integer iDisplayLength) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = buildReqUser(params);

            int pageIndex = iDisplayStart / iDisplayLength + 1;
            PageInfo<RespUserVo> pageInfo = sysUserService.queryAllAccountsForPage(reqSysUser, pageIndex, iDisplayLength);
            if (pageInfo != null && CollectionUtils.isEmpty(pageInfo.getList())) {
                respCode = RespCommCode.QUERY_RESULT_NULL.getKey();
                respMsg = RespCommCode.QUERY_RESULT_NULL.getValue();
            }
            respData = super.respParamsFormat(respCode, respMsg, sEcho, pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    @RequestMapping(value = "/queryAccountDetailById.do")
    @ResponseBody
    public ModelMap queryAccountDetailById(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long userId = params.getLong("userId");

            RespUserVo respUserVo = sysUserService.queryAccountInfoById(userId);
            respData = super.respParamsFormat(respCode, respMsg, respUserVo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 修改账号的启用状态
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateAccountStatusById.do")
    @ResponseBody
    public ModelMap updateAccountStatusById(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SAVE_SUCCESS.getKey();
        String respMsg = RespCommCode.SAVE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long userId = params.getLong("userId");
            Integer status = params.getInteger("status");

            int result = sysUserService.updateUserStatusById(userId, status);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 保存账号信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveAccountInfo.do")
    @ResponseBody
    public ModelMap saveAccountInfo(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SAVE_SUCCESS.getKey();
        String respMsg = RespCommCode.SAVE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = buildReqUser(params);

            int result = sysUserService.saveSysUserInfo(reqSysUser);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 根据用户主键ID删除用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeAccountById.do")
    @ResponseBody
    public ModelMap removeAccountById(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.DELETE_SUCCESS.getKey();
        String respMsg = RespCommCode.DELETE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long userId = params.getLong("userId");

            int result = sysUserService.removeSysUserById(userId);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 查询菜单列表集合
     *
     * @param request
     * @param sEcho
     * @param iDisplayStart
     * @param iDisplayLength
     * @return
     */
    @RequestMapping(value = "/querySysMenuList.do")
    @ResponseBody
    public ModelMap querySysMenuList(HttpServletRequest request, Integer sEcho,
                                   Integer iDisplayStart, Integer iDisplayLength) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = new ReqSysUser();
            reqSysUser.setMenuId(params.getLong("menuId"));
            reqSysUser.setMenuName(params.getString("menuName"));

            int pageIndex = iDisplayStart / iDisplayLength + 1;
            PageInfo<RespSysMenuVo> pageInfo = sysUserService.queryAllMenusForPage(reqSysUser, pageIndex, iDisplayLength);
            if (pageInfo != null && CollectionUtils.isEmpty(pageInfo.getList())) {
                respCode = RespCommCode.QUERY_RESULT_NULL.getKey();
                respMsg = RespCommCode.QUERY_RESULT_NULL.getValue();
            }
            respData = super.respParamsFormat(respCode, respMsg, sEcho, pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 未参与分页的菜单列表查询
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryAllMenus.do")
    @ResponseBody
    public ModelMap queryAllMenus(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = buildReqUser(params);

            List<RespSysMenuVo> respSysMenuVoList = sysUserService.queryAllSysMenus(reqSysUser);
            respData = super.respParamsFormat(respCode, respMsg, respSysMenuVoList);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    @RequestMapping(value = "/querySysMenuInfoById.do")
    @ResponseBody
    public ModelMap querySysMenuInfoById(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long menuId = params.getLong("menuId");

            RespSysMenuVo respSysMenuVo = sysUserService.querySysMenuInfoById(menuId);
            respData = super.respParamsFormat(respCode, respMsg, respSysMenuVo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 保存菜单信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveMenuInfo.do")
    @ResponseBody
    public ModelMap saveMenuInfo(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SAVE_SUCCESS.getKey();
        String respMsg = RespCommCode.SAVE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = buildReqUser(params);

            int result = sysUserService.saveSysMenuInfo(reqSysUser);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 根据菜单主键ID删除菜单信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeMenuById.do")
    @ResponseBody
    public ModelMap removeMenuById(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.DELETE_SUCCESS.getKey();
        String respMsg = RespCommCode.DELETE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long menuId = params.getLong("menuId");

            int result = sysUserService.removeSysMenuById(menuId);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 查询角色列表集合
     *
     * @param request
     * @param sEcho
     * @param iDisplayStart
     * @param iDisplayLength
     * @return
     */
    @RequestMapping(value = "/querySysRoleList.do")
    @ResponseBody
    public ModelMap querySysRoleList(HttpServletRequest request, Integer sEcho,
                                  Integer iDisplayStart, Integer iDisplayLength) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = new ReqSysUser();
            reqSysUser.setRoleId(params.getLong("roleId"));
            reqSysUser.setRoleName(params.getString("roleName"));

            int pageIndex = iDisplayStart / iDisplayLength + 1;
            PageInfo<RespRoleVo> pageInfo = sysUserService.queryAllRolesForPage(reqSysUser, pageIndex, iDisplayLength);
            if (pageInfo != null && CollectionUtils.isEmpty(pageInfo.getList())) {
                respCode = RespCommCode.QUERY_RESULT_NULL.getKey();
                respMsg = RespCommCode.QUERY_RESULT_NULL.getValue();
            }
            respData = super.respParamsFormat(respCode, respMsg, sEcho, pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 查询所有的角色信息列表(构建角色下拉列表数据，不分页)
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryAllRoles.do")
    @ResponseBody
    public ModelMap queryAllRoles(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = buildReqUser(params);

            List<RespRoleVo> respRoleVoList = sysUserService.queryAllSysRoles(reqSysUser);
            respData = super.respParamsFormat(respCode, respMsg, respRoleVoList);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    @RequestMapping(value = "/querySysRoleInfoById.do")
    @ResponseBody
    public ModelMap querySysRoleInfoById(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long roleId = params.getLong("roleId");

            RespRoleVo respRoleVo = sysUserService.querySysRoleInfoById(roleId);
            respData = super.respParamsFormat(respCode, respMsg, respRoleVo);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     * 保存角色信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveRoleInfo.do")
    @ResponseBody
    public ModelMap saveRoleInfo(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SAVE_SUCCESS.getKey();
        String respMsg = RespCommCode.SAVE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqSysUser reqSysUser = buildReqUser(params);

            int result = sysUserService.saveSysRoleInfo(reqSysUser);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /***
     * 根据角色主键删除角色信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeRoleById.do")
    @ResponseBody
    public ModelMap removeRoleById(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.DELETE_SUCCESS.getKey();
        String respMsg = RespCommCode.DELETE_SUCCESS.getValue();

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Long roleId = params.getLong("menuId");

            int result = sysUserService.removeSysRoleById(roleId);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
        }
        return resultMap;
    }

    /**
     *
     *
     * @param params
     * @return
     */
    private ReqSysUser buildReqUser(JSONObject params) {
        Long userId = params.getLong("userId");
        String userName = params.getString("userName");
        String realName = params.getString("realName");
        Long roleId = params.getLong("roleId");

        String roleName = params.getString("roleName");
        Long menuId = params.getLong("menuId");
        Long parentMenuId = params.getLong("parentMenuId");
        String menuName = params.getString("menuName");
        String password = params.getString("password");
        String email = params.getString("email");
        String mobile = params.getString("mobile");
        String deptName = params.getString("deptName");
        String remark = params.getString("remark");
        String linkUrl = params.getString("linkUrl");
        String perms = params.getString("perms");
        String iconUrl = params.getString("iconUrl");
        Integer menuType = params.getInteger("menuType");
        Integer orderNum = params.getInteger("orderNum");
        String routerName = params.getString("routerName");
        String routerPath = params.getString("routerPath");


        ReqSysUser reqSysUser = new ReqSysUser();

        JSONArray direCheck = params.getJSONArray("direCheck");
        JSONArray menuCheck = params.getJSONArray("menuCheck");
        JSONArray permsCheck = params.getJSONArray("permsCheck");

        int index = 0;
        if(direCheck != null && !direCheck.isEmpty()){
            Long[] direArr = new Long[direCheck.size()];
            Iterator iterator = direCheck.iterator();
            while (iterator.hasNext()) {
                String val = (String)iterator.next();
                direArr[index] = Long.valueOf(val);
                index++;
            }
            reqSysUser.setDireArr(direArr);
            index = 0;
        }
        if(menuCheck != null && !menuCheck.isEmpty()){
            Long[] menuArr = new Long[menuCheck.size()];
            Iterator iterator = menuCheck.iterator();
            while (iterator.hasNext()) {
                String val = (String)iterator.next();
                menuArr[index] = Long.valueOf(val);
                index++;
            }
            reqSysUser.setMenuArr(menuArr);
            index = 0;
        }
        if(permsCheck != null && !permsCheck.isEmpty()){
            Long[] permsArr = new Long[permsCheck.size()];
            Iterator iterator = permsCheck.iterator();
            while (iterator.hasNext()) {
                String val = (String)iterator.next();
                permsArr[index] = Long.valueOf(val);
                index++;
            }
            reqSysUser.setPermsArr(permsArr);
        }

        reqSysUser.setUserId(userId);
        reqSysUser.setUserName(userName);
        reqSysUser.setPassword(password);
        reqSysUser.setRealName(realName);
        reqSysUser.setEmail(email);
        reqSysUser.setMobile(mobile);
        reqSysUser.setDeptName(deptName);
        //角色相关属性
        reqSysUser.setRoleId(roleId);
        reqSysUser.setRoleName(roleName);
        reqSysUser.setRemark(remark);
        //菜单相关属性
        reqSysUser.setMenuId(menuId);
        reqSysUser.setParentMenuId(parentMenuId);
        reqSysUser.setMenuName(menuName);
        reqSysUser.setLinkUrl(linkUrl);
        reqSysUser.setIconUrl(iconUrl);
        reqSysUser.setMenuType(menuType);
        reqSysUser.setPerms(perms);
        reqSysUser.setOrderNum(orderNum);
        reqSysUser.setRouterName(routerName);
        reqSysUser.setRouterPath(routerPath);

        return reqSysUser;
    }
}
