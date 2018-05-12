package com.xbc.tutstreams.creation;

import java.util.function.Supplier;

public class SequenceSupplier implements Supplier<Integer> {
  public static int u0 , ui = 0;
  public static boolean started = false ;

  @Override
  public Integer get() {
    if (!started)
      started = true;
    else
      ui = 2*ui + 1 ;

    return ui;
  }

  public void reset() {
    started = false;
    ui = u0;
  }
}