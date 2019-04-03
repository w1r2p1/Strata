/*
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.swap;

import static com.opengamma.strata.collect.Guavate.toImmutableList;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.basics.currency.Currency;

/**
 * A rate swap.
 * <p>
 * A rate swap is a financial instrument that represents the exchange of streams of payments.
 * The swap is formed of legs, where each leg typically represents the obligations
 * of the seller or buyer of the swap. In the simplest vanilla interest rate swap,
 * there are two legs, one with a fixed rate and the other a floating rate.
 * Many other more complex swaps can also be represented.
 * <p>
 * For example, a swap might involve an agreement to exchange the difference between
 * the fixed rate of 1% and the 'GBP-LIBOR-3M' rate every 3 months for 2 years.
 */
public final class Swap {

  public Swap(List<SwapLeg> legs) {
    this.legs = ImmutableList.copyOf(legs);
  }

  /**
   * The legs of the swap.
   * <p>
   * A swap consists of one or more legs.
   * The legs of a swap are essentially unordered, however it is more efficient
   * and closer to user expectation to treat them as being ordered.
   */
  private final ImmutableList<SwapLeg> legs;


  /**
   * Ges the legs of the swap.
   * 
   * @return the legs of the swap
   */
  public ImmutableList<SwapLeg> getLegs() {
    return legs;
  }
  
  //-------------------------------------------------------------------------
  /**
   * Gets the legs of the swap with the specified type.
   * <p>
   * This returns all the legs with the given type.
   * 
   * @param type  the type to find
   * @return the matching legs of the swap
   */
  public ImmutableList<SwapLeg> getLegs(SwapLegType type) {
    return legs.stream().filter(leg -> leg.getType() == type).collect(toImmutableList());
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the accrual start date of the swap.
   * <p>
   * This is the earliest accrual date of the legs, often known as the effective date.
   * The latest date is chosen by examining the unadjusted end date.
   * 
   * @return the start date of the swap
   */
  public LocalDate getStartDate() {
    return legs.stream()
        .map(SwapLeg::getStartDate)
        .min(Comparator.naturalOrder())
        .get();  // always at least one leg, so get() is safe
  }

  /**
   * Gets the accrual end date of the swap.
   * <p>
   * This is the latest accrual date of the legs, often known as the termination date.
   * The latest date is chosen by examining the unadjusted end date.
   * 
   * @return the end date of the swap
   */
  public LocalDate getEndDate() {
    return legs.stream()
        .map(SwapLeg::getEndDate)
        .max(Comparator.naturalOrder())
        .get();  // always at least one leg, so get() is safe
  }

  /**
   * Returns the set of currencies referred to by the swap.
   * <p>
   * This returns the complete set of currencies for the swap, not just the payment currencies.
   * 
   * @return the set of currencies referred to by this swap
   */
  public ImmutableSet<Currency> allCurrencies() {
    // TODO
  }
}
