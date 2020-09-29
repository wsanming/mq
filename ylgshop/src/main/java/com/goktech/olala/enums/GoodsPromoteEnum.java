package com.goktech.olala.enums;

public enum GoodsPromoteEnum {
	 /**
	   * 0 精品
	   */
	  fine("精品",0),
	  /**
	   * 1 限时购
	   */
	  limit("限时购",1), 
	  /**
	   * 2 特价
	   */
	  cheap("特价",2);
	  
	  private String value;
	 
	  private int index;
	 
	  private GoodsPromoteEnum(String value, int index) {
	    this.value = value;
	    this.index = index;
	  }
	  
	  public static GoodsPromoteEnum get(String value){
	    for (GoodsPromoteEnum p : GoodsPromoteEnum.values()) {
	      if (p.getValue().equals(value)) {
	        return p;
	      }
	    }
	    return null;
	  }
	  
	  public static GoodsPromoteEnum get(int index){
	    for (GoodsPromoteEnum p : GoodsPromoteEnum.values()) {
	      if (p.getIndex() == index) {
	        return p;
	      }
	    }
	    return null;
	  }
	 
	  public String getValue() {
	    return value;
	  }
	 
	  public void setValue(String value) {
	    this.value = value;
	  }
	 
	  public int getIndex() {
	    return index;
	  }
	 
	  public void setIndex(int index) {
	    this.index = index;
	  }
}
