/*
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.swap;

/**
 * The type of a swap leg.
 * <p>
 * This provides a high-level categorization of a swap leg.
 * This is useful when it is necessary to find a specific leg.
 */
public enum SwapLegType {

  /**
   * A fixed rate swap leg.
   * All periods in this leg must have a fixed rate.
   */
  FIXED,
  /**
   * A floating rate swap leg based on an Ibor index.
   * <p>
   * This kind of leg may include some fixed periods, such as in a stub or
   * where the first rate is specified in the contract.
   */
  IBOR,
  /**
   * A floating rate swap leg based on an Overnight index.
   * <p>
   * This kind of leg may include some fixed periods, such as in a stub or
   * where the first rate is specified in the contract.
   */
  OVERNIGHT,
  /**
   * A floating rate swap leg based on an price index.
   * <p>
   * This kind of leg may include some reference dates 
   * where the index rate is specified.
   */
  INFLATION,
  /**
   * A swap leg that is not based on a Fixed, Ibor, Overnight or Inflation rate.
   */
  OTHER;

}
