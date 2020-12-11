package com.mgarcia01752.channelcapacity.main;

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
	}

}
