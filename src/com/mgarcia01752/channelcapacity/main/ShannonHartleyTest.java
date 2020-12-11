package com.mgarcia01752.channelcapacity.main;

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

import com.mgarcia01752.channelcapacity.ChannelCapacity;

public class ShannonHartleyTest {

	public static void main(String[] args) {

		for(int iBPS = 1; iBPS < 20; iBPS++) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("BitsPerSecond: " + ChannelCapacity.BitsPerSecond(iBPS, 50000));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 51 dB " + ChannelCapacity.Limit(iBPS, 50000, 51.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 49 dB " + ChannelCapacity.Limit(iBPS, 50000, 49.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 46 dB " + ChannelCapacity.Limit(iBPS, 50000, 46.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 43 dB " + ChannelCapacity.Limit(iBPS, 50000, 43.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 40 db " + ChannelCapacity.Limit(iBPS, 50000, 40.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 35 dB " + ChannelCapacity.Limit(iBPS, 50000, 35.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 30 dB " + ChannelCapacity.Limit(iBPS, 50000, 30.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 25 dB " + ChannelCapacity.Limit(iBPS, 50000, 25.0));
			System.out.println("ShannonCapacity: " + iBPS + "-BitsPerSymbol + 50KHz + MER: 20 dB " + ChannelCapacity.Limit(iBPS, 50000, 20.0));
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		for(int iBitsPerSymbol = 1; iBitsPerSymbol < 20; iBitsPerSymbol++) {
			System.out.println("ShannonCapacity: " + iBitsPerSymbol + "-BitsPerSymbol -> Min SNR: " + ChannelCapacity.MinSignalToNoise(iBitsPerSymbol));
		}

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		for(double dSignal2Noise = 1; dSignal2Noise < 60; dSignal2Noise++) {
			System.out.println("ShannonCapacity: " + dSignal2Noise + "-Signal2Noise -> Min bits-per-symbol: " + ChannelCapacity.BitsPerSymbol(dSignal2Noise));
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		for(int iNumOfSymbols = 1; iNumOfSymbols <= 256; iNumOfSymbols++) {
			System.out.println("ShannonCapacity: " + iNumOfSymbols + "-Num-of-symbols -> bits-per-symbol: " + ChannelCapacity.getBitsPerSymbolFromMary(iNumOfSymbols));
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		for(int iBitsPerSymbol = 1; iBitsPerSymbol <= 8; iBitsPerSymbol++) {
			System.out.println("ShannonCapacity: " + iBitsPerSymbol + "-BitsPerSymbol -> Num-of-symbol(QAM): " + ChannelCapacity.getMaryFromBitsPerSymbol(iBitsPerSymbol));
		}
		
	}

}
