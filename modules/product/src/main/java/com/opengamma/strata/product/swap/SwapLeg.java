/*
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.swap;

import java.time.LocalDate;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.product.common.PayReceive;

/**
 * A single leg of a swap.
 * <p>
 * A swap leg is one element of a {@link Swap}.
 * In most cases, a swap has two legs, one expressing the obligations of the seller
 * and one expressing the obligations of the buyer. However, it is possible to
 * represent more complex swaps, with one, three or more legs.
 * <p>
 * This interface imposes few restrictions on the swap leg. A leg must have a start and
 * end date, where the start date can be before or after the date that the swap is traded.
 * A single swap leg must produce payments in a single currency.
 */
public interface SwapLeg {

  /**
   * Gets the type of the leg, such as Fixed or Ibor.
   * <p>
   * This provides a high level categorization of the swap leg.
   * 
   * @return the leg type
   */
  public abstract SwapLegType getType();

  /**
   * Gets whether the leg is pay or receive.
   * <p>
   * A value of 'Pay' implies that the resulting amount is paid to the counterparty.
   * A value of 'Receive' implies that the resulting amount is received from the counterparty.
   * 
   * @return the pay receive flag
   */
  public abstract PayReceive getPayReceive();

  /**
   * Gets the accrual start date of the leg.
   * <p>
   * This is the first accrual date in the leg, often known as the effective date.
   * 
   * @return the start date of the leg
   */
  public abstract LocalDate getStartDate();

  /**
   * Gets the accrual end date of the leg.
   * <p>
   * This is the last accrual date in the leg, often known as the termination date.
   * 
   * @return the end date of the leg
   */
  public abstract LocalDate getEndDate();

  //-------------------------------------------------------------------------
  /**
   * Gets the payment currency of the leg.
   * 
   * @return the payment currency of the leg
   */
  public abstract Currency getCurrency();
}
