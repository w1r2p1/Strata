/*
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.common;

/**
 * Flag indicating whether a financial instrument is "pay" or "receive".
 * <p>
 * Specifies the direction of payments.
 * For example, a swap typically has two legs, a pay leg, where payments are made
 * to the counterparty, and a receive leg, where payments are received.
 */
public enum PayReceive {

  /**
   * Pay.
   */
  PAY,
  /**
   * Receive.
   */
  RECEIVE;
}
