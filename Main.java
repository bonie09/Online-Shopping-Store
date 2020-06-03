import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Data
{
    String student[][]=new String[5][2];
    int cart[][] = new int[5][1];
    int amount[][] = new int[5][1];
    String bag[][] = new String[5][15];
    String name,sid;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Data()
    {
        student[0][0]="Bonie";
        student[0][1]="98";
        cart[0][0] = 0;
        amount[0][0] = 0;
        student[1][0]="Kunal";
        student[1][1]="94";
        cart[1][0] = 0;
        amount[1][0] = 0;
        student[2][0]="Mohit";
        student[2][1]="118";
        cart[2][0] = 0;
        amount[2][0] = 0;
        student[3][0]="Rohit";
        student[3][1]="80";
        cart[3][0] = 0;
        amount[3][0] = 0;
        student[4][0]="Akshay";
        student[4][1]="65";
        cart[4][0] = 0;
        amount[4][0] = 0;
    }
    void read()throws IOException
    {
        System.out.println("Enter the name");
        name=br.readLine();
        System.out.println("Enter the id");
        sid=br.readLine();
    }
}
class Tshirts
{
    String ts[][]=new String[6][3];
    int count[][]=new int[6][1];
    String s[][]=new String[6][3];
    int scount[][]=new int[6][1];
    String jeans[][] = new String[6][3];
    int jcount[][] = new int[6][1]; 
    Tshirts()
    {
        ts[0][0]="Zara";
        ts[0][1]="M";
        ts[0][2]="1188";
        count[0][0]=5;
        ts[1][0]="Being Human";
        ts[1][1]="M";
        ts[1][2]="1999";
        count[1][0]=5;
        ts[2][0]="Jack & Jones";
        ts[2][1]="M";
        ts[2][2]="2599";
        count[2][0]=5;        
        ts[3][0]="H&M";
        ts[3][1]="M";
        ts[3][2]="1099";
        count[3][0]=5;
        ts[4][0]="Zara";
        ts[4][1]="S";
        ts[4][2]="1099";
        count[4][0]=5;
        ts[5][0]="Being Human";
        ts[5][1]="XL";
        ts[5][2]="899";
        count[5][0]=5;

        s[0][0]="Mufti";
        s[0][1]="S";
        s[0][2]="2599";
        scount[0][0]=5;
        s[1][0]="Tommy Hilfiger";
        s[1][1]="M";
        s[1][2]="1999";
        scount[1][0]=5;
        s[2][0]="Jack & Jones";
        s[2][1]="M";
        s[2][2]="3099";
        scount[2][0]=5;        
        s[3][0]="Calvin Klein";
        s[3][1]="XL";
        s[3][2]="2299";
        scount[3][0]=5;
        s[4][0]="Zara";
        s[4][1]="S";
        s[4][2]="1499";
        scount[4][0]=5;
        s[5][0]="Being Human";
        s[5][1]="XL";
        s[5][2]="1749";
        scount[5][0]=5;

        jeans[0][0]="UCB";
        jeans[0][1]="42";
        jeans[0][2]="3099";
        jcount[0][0]=5;
        jeans[1][0]="Being Human";
        jeans[1][1]="38";
        jeans[1][2]="1899";
        jcount[1][0]=5;
        jeans[2][0]="Jack & JonesJ";
        jeans[2][1]="40";
        jeans[2][2]="3499";
        jcount[2][0]=5;        
        jeans[3][0]="UCB";
        jeans[3][1]="36";
        jeans[3][2]="2899";
        jcount[3][0]=5;
        jeans[4][0]="Zara";
        jeans[4][1]="30";
        jeans[4][2]="3599";
        jcount[4][0]=5;
        jeans[5][0]="Calvin Klein";
        jeans[5][1]="28";
        jeans[5][2]="2549";
        jcount[5][0]=5;
    }
}

class Clothes extends Tshirts
{
    int i,j,in,k,pr,z=0,bag;
    boolean found=false,flag=false;
    String id,brand,size,prod;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Data d=new Data();
    Main m=new Main();

    void cart(int in)throws IOException{
        int y,cc;
        if(d.cart[in][0] !=0){
            System.out.println("\nWelcome to your cart!!\n-------------------------------\n");
            for(y=0;y<d.bag[in].length;y++){
                if(d.bag[in][y] != null){
                    System.out.println(d.bag[in][y]);
                }
            }
            System.out.println("Press 1 to proceed with a payment else press 0 to continue shopping");
            cc = Integer.parseInt(br.readLine());
            if(cc==1){
                System.out.println("The total amount to be paid is: "+d.amount[in][0]+"\n");
                d.amount[in][0] = 0;
                d.cart[in][0] = 0;
                for(y=0;y<d.bag[in].length;y++){
                    if(d.bag[in][y] != null){
                        d.bag[in][y] = null;
                    }
                }
                m.menu1();
            }else if(cc==0){
                m.menu(in);
            }
        }
        else{
            System.out.println("Your cart is empty");
            m.menu(in);
        }
    }

    void bag(String brand, String size, int in, int i, String c[][], String prod)throws IOException{
        int conv;
        System.out.println("Adding this item into your cart");
        count[i][0]--;
        d.cart[in][0]++;
        conv = Integer.parseInt(ts[i][2]);
        d.amount[in][0] = d.amount[in][0] + conv;
        d.bag[in][z++] = "Product: "+prod+ " Brand: " +c[i][0] + " Size: " + c[i][1] + " Prize:" + c[i][2] +"\n----------------------------------------------------------\n";
        System.out.println("\nNo. of items in your cart(s) are:\n"+d.cart[in][0]);
    }

    void tshirts(int in)throws IOException
    {
        prod = "Tshirt";
        System.out.println("Tshirts available in store are: \n");   
        for(i=0;i<ts.length;i++){
            System.out.println("Brand: "+ts[i][0]);
            System.out.println("Size: "+ts[i][1]);
            System.out.println("Prize: "+ts[i][2]);
            System.out.println("Available number of product: "+count[i][0]);
            System.out.println("\n");
        }
        System.out.println("Enter the brand and size to add into your cart:");
        brand = br.readLine();
        size = br.readLine();
        for(i=0;i<5;i++)
        {
            if((ts[i][0].compareToIgnoreCase(brand)==0) && (ts[i][1].compareToIgnoreCase(size)==0))
            {
                found=true;
                break;
            }
        }
        if(found==true){
            System.out.println("Press 1 to add this item in your cart else press 0");
            pr = Integer.parseInt(br.readLine());
            if(pr == 1){
                bag(brand, size, in, i,ts, prod);
            }else{
                m.menu(in);
            }
        }
        else{
            System.out.print("Tshirt is not available");
        }
    }

    void shirts(int in)throws IOException{
        prod = "Shirt";
        System.out.println("Shirts available in store are: \n");   
        for(i=0;i<s.length;i++){
            System.out.println("Brand: "+s[i][0]);
            System.out.println("Size: "+s[i][1]);
            System.out.println("Prize: "+s[i][2]);
            System.out.println("Available number of product: "+scount[i][0]);
            System.out.println("\n");
        }
        System.out.println("Enter the brand and size to add into your cart:");
        brand = br.readLine();
        size = br.readLine();
        for(i=0;i<5;i++)
        {
            if((s[i][0].compareToIgnoreCase(brand)==0) && (s[i][1].compareToIgnoreCase(size)==0))
            {
                found=true;
                break;
            }
        }
        if(found==true){
            System.out.println("Press 1 to add this item in your cart else press 0");
            pr = Integer.parseInt(br.readLine());
            if(pr == 1){
                System.out.println(brand);
                bag(brand, size, in, i, s, prod);
            }else{
                m.menu(in);
            }
        }
        else{
            System.out.print("Shirt is not available");
        }
    }

    void jeans(int in)throws IOException
    {
        prod = "Jeans";
        System.out.println("Jeans available in store are: \n");   
        for(i=0;i<jeans.length;i++){
            System.out.println("Brand: "+jeans[i][0]);
            System.out.println("Size: "+jeans[i][1]);
            System.out.println("Prize: "+jeans[i][2]);
            System.out.println("Available number of product: "+jcount[i][0]);
            System.out.println("\n");
        }
        System.out.println("Enter the brand and size to add into your cart:");
        brand = br.readLine();
        size = br.readLine();
        for(i=0;i<5;i++)
        {
            if((jeans[i][0].compareToIgnoreCase(brand)==0) && (jeans[i][1].compareToIgnoreCase(size)==0))
            {
                found=true;
                break;
            }
        }
        if(found==true){
            System.out.println("Press 1 to add this item in your cart else press 0");
            pr = Integer.parseInt(br.readLine());
            if(pr == 1){
                bag(brand, size, in, i,jeans, prod);
            }else{
                m.menu(in);
            }
        }
        else{
            System.out.print("Jean is not available");
        }
    }
}
class Main
{
    static int ch,op,i,in;
    static Data d=new Data();
    static Clothes c=new Clothes();
    static Main m=new Main();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        m.menu1();
    }

    void menu(int in)throws IOException{
        do
        {
            System.out.println("************SELECT A CATEGORY************\n1.Tshirts\n2.Shirts\n3.Jeans\n4.View your cart\n5.EXIT\nEnter option");
            op=Integer.parseInt(br.readLine());
            switch(op)
            {
                case 1:c.tshirts(in);
                break;
                case 2:c.shirts(in);
                break;
                case 3:c.jeans(in);
                break;
                case 4:c.cart(in);
                break;
                case 5:System.out.println("Thank You!!!!!");
                        m.menu1();
                        break;
                default:System.out.println("Invalid option");
            }
        }while(op!=4);
    }

    void menu1(){
    	System.out.println("===========Welcome to Online Shopping Store==========");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
        	System.out.println("Enter your details for login in");
	        d.read();
	        for(i=0;i<5;i++){
                if(d.student[i][0].compareToIgnoreCase(d.name)==0&&d.student[i][1].compareTo(d.sid)==0)
                {
                    in = i;
                    m.menu(in);
                }
            }
        }
        catch(Exception e)
        {

        }
	}
}

class UserException extends Exception
{
    UserException()
     {
        System.out.println("Invalid Credentials");
     }
}