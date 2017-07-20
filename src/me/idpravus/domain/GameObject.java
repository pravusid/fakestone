package me.idpravus.domain;

import me.idpravus.data.GameObjectType;

public interface GameObject {

	public GameObjectType getType();
	
    public String getName();

    public int getCost();

    public int getAtk();

    public int getDef();

}
