package com.shiguiwu.admin.util;




/**
 * @author lw
 */

public enum ModelName {
    /**
     * 计费模式
     */
    CPC(1),CPM(2),CPA(3),CPT(4);
    private int type;

    ModelName(int type) {
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public static ModelName getEnum(int value) {
        for (ModelName model : values()) {
            if (model.getType() == value) {
                return model;
            }
        }
        return null;
    }

}
