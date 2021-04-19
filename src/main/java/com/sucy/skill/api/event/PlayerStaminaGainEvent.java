package com.sucy.skill.api.event;

import com.sucy.skill.api.enums.StaminaSource;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerStaminaGainEvent extends Event implements Cancellable
{
    private static final HandlerList handlers = new HandlerList();
    private PlayerData player;
    private StaminaSource source;
    private boolean    cancelled;
    private double     amount;

    /**
     * Constructor
     *
     * @param player class of the player gaining experience
     * @param amount amount of stamina regenerated
     * @param source the source of the gained stamina
     */
    public PlayerStaminaGainEvent(PlayerData player, double amount, StaminaSource source)
    {
        this.player = player;
        this.source = source;
        this.amount = amount;
        cancelled = false;
    }

    /**
     * @return data of the player gaining experience
     */
    public PlayerData getPlayerData()
    {
        return player;
    }

    /**
     * @return amount of experience being gained
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     * @return source of the gained stamina
     */
    public StaminaSource getSource()
    {
        return source;
    }

    /**
     * Sets the amount of experience being gained
     *
     * @param amount new amount of experience
     *
     * @throws IllegalArgumentException if experience is less than 0
     */
    public void setAmount(double amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Regenerated mana cannot be negative");
        }

        this.amount = amount;
    }

    /**
     * @return whether or not the gain in experience is cancelled
     */
    @Override
    public boolean isCancelled()
    {
        return cancelled;
    }

    /**
     * Sets whether or not the gain in experience is cancelled
     *
     * @param cancelled true/false
     */
    @Override
    public void setCancelled(boolean cancelled)
    {
        this.cancelled = cancelled;
    }

    /**
     * @return gets the handlers for the event
     */
    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * @return gets the handlers for the event
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}