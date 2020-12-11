package com.mgarcia01752.channelcapacity;

/*
 * 	Licensed to the Apache Software Foundation (ASF) under one
	or more contributor license agreements.  See the NOTICE file
	distributed with this work for additional information
	regarding copyright ownership.  The ASF licenses this file
	to you under the Apache License, Version 2.0 (the
	"License"); you may not use this file except in compliance
	with the License.  You may obtain a copy of the License at
	
	  http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing,
	software distributed under the License is distributed on an
	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
	KIND, either express or implied.  See the License for the
	specific language governing permissions and limitations
	under the License.
	
	Author: Maurice Garcia
	email:	mgarcia01752@outlook.com
 */

public class ChannelCapacity {

	  /**
	   * 
	   * @param iBitsPerSymbol
	   * @param dChannelBWHz
	   * @return BitsPerSecond theoretical bandwidth
	   */
	  public static double BitsPerSecond(int iBitsPerSymbol, double dChannelBWHz) {
	    return iBitsPerSymbol * dChannelBWHz;
	  }

	  /**
	   * @see https://en.wikipedia.org/wiki/Shannon%E2%80%93Hartley_theorem
	   * 
	   * @param dChannelBWHz
	   * @param dSNRdB - MERdB(Can Be Used)
	   * @return double BitsPerSecond theoretical bandwidth when noise is applied to channel
	   */
	  public static double Bandwidth(double dChannelBWHz, double dSNRdB) {
	    return dChannelBWHz * (Math.log(1 + (Math.pow(10.0, (dSNRdB / 10.0)))) / Math.log(2));
	  }

	  /**
	   * 
	   * @param iBitsPerSymbol
	   * @param dChannelBWHz
	   * @param dSNRdB
	   * @return True if the number of bits-per-symbol is supported with applied signal-to-noise
	   */
	  public static boolean Limit(int iBitsPerSymbol, double dChannelBWHz, double dSNRdB) {
	    boolean boolUnderCapacity = false;
	    if (BitsPerSecond(iBitsPerSymbol, dChannelBWHz) <= Bandwidth(dChannelBWHz, dSNRdB)) {
	      boolUnderCapacity = true;
	    }
	    return boolUnderCapacity;
	  }
	  
	  /**
	   * 
	   * @param iBitsPerSymbol
	   * @param dChannelBWHz
	   * @param dSNRdB
	   * @param dSNRActualDelta This value represent the actual real word delta since LDPC is about .3 - .6 delta to actual ShannonLimit
	   * @return True if the number of bits-per-symbol is supported with applied signal-to-noise and an estimated LDPC/BCH FEC applied
	   */
	  public static boolean Limit(int iBitsPerSymbol, double dChannelBWHz, double dSNRdB, double dSNRActualDelta) {
		  boolean boolUnderCapacity = false;
		  if (BitsPerSecond(iBitsPerSymbol, dChannelBWHz) <= Bandwidth(dChannelBWHz, dSNRdB) + dSNRActualDelta) {
			  boolUnderCapacity = true;
		  }
		  return boolUnderCapacity;
	  }

	  /**
	   * 
	   * @param iBitsPerSymbol
	   * @return Theoretical minimum signal-to-noise need to support bits-per-symbol
	   */
	  public static double MinSignalToNoise(int iBitsPerSymbol) {
	    return 10.0 * Math.log10(Math.pow(2, iBitsPerSymbol) - 1);
	  }

	  /**
	   * 
	   * @param dSNR in dB
	   * @return Theoretical minimum bits-per-symbol when applied signal-to-noise
	   */
	  public static int BitsPerSymbol(double dSNR) {
	    return (int) Math.floor((Math.log(1 + (Math.pow(10.0, (dSNR / 10.0)))) / Math.log(2)));
	  }
	  
	  /**
	   * 
	   * @param dSNR
	   * @return Fractional BitsPerSymbol log_2(1 + 10^(SNR/10)
	   */
	  public static double BitsPerSymbolDecimal(double dSNR) {
		    return (Math.log(1 + (Math.pow(10.0, (dSNR / 10.0)))) / Math.log(2));
	  }
	  
	  /**
	   * 
	   * @param iMary Number of symbols
	   * @return log_2(Mary) Number of bits represted by the symbol
	   */
	  public static int getBitsPerSymbolFromMary(int iMary) {
		  return (int) (Math.log(iMary)/Math.log(2));
	  }
	  
	  /**
	   * 
	   * @param iBitsTransmitted Number of bits transmitted
	   * @return Number of symbols needed to represent required transmitted bits-per-symbol
	   */
	  public static int getMaryFromBitsPerSymbol(int iBitsPerSymbol) {
		  return (int) Math.pow(2, iBitsPerSymbol);
	  }
	  
	  /**
	   * 
	   * @param dSNR
	   * @return Fractional Percentage - Example: 10.5 - 10.0 = .5 or 50%
	   */
	  public static double getSNRMinBPSymPercentage(double dSNR) {	  
		  return (BitsPerSymbolDecimal(dSNR) -(double)BitsPerSymbol(dSNR));
	  }
	
}
