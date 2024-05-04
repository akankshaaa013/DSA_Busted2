## Bit Manipulation Tips and Tricks

##### XOR:a^1='a' complement, a^0=a, a^a=0
##### Get the last digit: n&1
##### Right shift: a>>b=a/2pow(b)
##### left shift: a<<b=a*2pow(b)
##### for range for n bits:-2pow(n-1) to 2pow(n-1)-1
##### Ignore the Last digit:n>>1
##### No of digits in base b of n=(int)(Math.log(n/Math.log(b))+1)
##### Integer.toBinaryString(n)
##### MSB=n&(-n)
##### 10.LSB=n-(n&(-n))
##### count set bit=>n&n-1
##### 2's Complement: -n=-5=-101=010+1=011
##### Power of 2=n&n-1==0
##### Set the kth bits of n: n|(1<<kth)
##### clear the kth bits of n: n&(~(1<<kth)
##### complement:n^((bitmask=pow(2,digits of binary)-1) or Integer.highestOneBit(n)<<1)-1
##### bit counts: Integer.bitCount(b);
##### in java. a=2,a>>3=>0
##### Integer.highestOneBit(8)<<1)-1
##### Integer.bitCount(n)
##### Integer.toBinaryString(n);Bit Manipulation
##### XOR:a^1='a' complement, a^0=a, a^a=0
##### Get the last digit: n&1
##### Right shift: a>>b=a/2pow(b)
##### left shift: a<<b=a*2pow(b)
##### for range for n bits:-2pow(n-1) to 2pow(n-1)-1
##### Ignore the Last digit:n>>1
##### No of digits in base b of n=(int)(Math.log(n/Math.log(b))+1)
##### Integer.toBinaryString(n)
##### MSB=n&(-n)
##### 10.LSB=n-(n&(-n))
##### count set bit=>n&n-1
##### 2's Complement: -n=-5=-101=010+1=011
##### Power of 2=n&n-1==0
##### Set the kth bits of n: n|(1<<kth)
##### clear the kth bits of n: n&(~(1<<kth)
##### complement:n^((bitmask=pow(2,digits of binary)-1) or Integer.highestOneBit(n)<<1)-1
##### in java. a=2,a>>3=>0
##### Integer.highestOneBit(8)<<1)-1
##### 0>>0=>0 and 0>>1=>0
##### Binary to Decimal: Integer.parseInt(bistr,2); String bistr="1100"