class Roman
{
    protected int intValue;
    protected String stringValue;

    Roman(String string)
    {
        this.stringValue = string;
        romanToInt();
    }

    Roman(int number)
    {
        this.intValue = number;
        intToRoman();
    }

    public int getValue(char r)
    {
        if(r=='I')
        {
            return 1;
        }
        if(r=='V')
        {
            return 5;
        }
        if(r=='X')
        {
            return 10;
        }
        if(r=='L')
        {
            return 50;
        }
        if(r=='C')
        {
            return 100;
        }
        if(r=='D')
        {
            return 500;
        }
        if(r=='M')
        {
            return 1000;
        }
        return -1;
    }


    public void romanToInt()
    {
        String str = stringValue;
        int sum = 0;

        for(int i = 0; i< str.length(); i++)
        {
            int z1 = getValue(str.charAt(i));

            if((i+1)<str.length())
            {
                int z2 = getValue(str.charAt(i+1));

                //sowas wie XX oder VI, also keine Besonderheit
                if(z1>=z2)
                {
                    sum = sum + z1;
                }
                //z.B. IV; index wird erhöht, da IV ja ein Symbol ist und man sonst V doppelt hätte
                else
                {
                    sum = sum + (z2-z1);
                    i++;
                }
            }
            else
            {
                sum = sum + z1;
            }
        }
        intValue = sum;
    }

    public void intToRoman()
    {
        int number = intValue;
        String str = "";

        while(number >= 1000)
        {
            str = str + "M";
            number = number - 1000;
        }
        while(number >= 900)
        {
            str = str + "CM";
            number = number - 900;
        }
        while(number >= 500)
        {
            str = str + "D";
            number = number - 500;
        }
        while(number >= 400)
        {
            str = str + "CD";
            number = number - 400;
        }
        while(number >= 100)
        {
            str = str + "C";
            number = number - 100;
        }
        while(number >= 90)
        {
            str = str + "XC";
            number = number - 90;
        }
        while(number >= 50)
        {
            str = str + "L";
            number = number - 50;
        }
        while(number >= 40)
        {
            str = str + "XL";
            number = number - 40;
        }
        while(number >= 10)
        {
            str = str + "X";
            number = number - 10;
        }
        while(number >= 9)
        {
            str = str + "IX";
            number = number - 9;
        }
        while(number >= 5)
        {
            str = str + "V";
            number = number - 5;
        }
        while(number >= 4)
        {
            str = str + "IV";
            number = number - 4;
        }
        while(number >= 1)
        {
            str = str + "I";
            number = number - 1;
        }
       
        stringValue = str;
    }

    public void add(Roman rom)
    { 
        intValue = rom.intValue + intValue;
        intToRoman();        
    }

    public void substract(Roman rom)
    {
        intValue = intValue - rom.intValue ;
        intToRoman();
    }

    public void multiply(Roman rom)
    {
        intValue = rom.intValue * intValue;
        intToRoman();
    }

    public Roman divide(Roman rom)
    {
        //hier noch neue tempwerte anlegen
        Roman result = new Roman(intValue);
        result.intValue = intValue / rom.intValue;
        result.intToRoman();
        return result;
    }

    public String toString()
    {
        return "Die römische Zahl " + stringValue + " entspricht " + intValue;
    }

    public int hashCode()
    {
        return intValue;
    }
}

public class Zahlen
{
    public static void main(String[] args) 
    {
        Roman test1 = new Roman("MMXIV");
        Roman test2 = new Roman(2022);
        test1.add(test2);
        test1.substract(test2);
        System.out.println(test1.toString());
    }
}