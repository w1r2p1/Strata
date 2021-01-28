/*
 * Copyright (C) 2021 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.loader.csv;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.collect.io.CsvRow;
import com.opengamma.strata.product.Trade;
import com.opengamma.strata.product.TradeInfo;

/**
 * Handles the CSV file format for CDS index trades.
 */
final class CdsIndexTradeCsvPlugin implements TradeCsvParserPlugin {

  /**
   * The singleton instance of the plugin.
   */
  public static final CdsIndexTradeCsvPlugin INSTANCE = new CdsIndexTradeCsvPlugin();

  //-------------------------------------------------------------------------
  @Override
  public Set<String> types() {
    return ImmutableSet.of("CDSINDEX", "CDS INDEX");
  }

  @Override
  public Trade parseTrade(CsvRow row, List<CsvRow> additionalRows, TradeInfo info, TradeCsvInfoResolver resolver) {
    return resolver.parseCdsIndexTrade(row, info);
  }

  @Override
  public String getName() {
    return "CdsIndex";
  }

}
