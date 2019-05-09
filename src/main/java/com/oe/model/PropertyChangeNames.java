
package com.oe.model;

public enum PropertyChangeNames {

    StageTableMade("StageTableMade");


    private final String name;

    PropertyChangeNames(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
