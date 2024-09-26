
class A11_Shared{
    int data,flg;
    A11_Shared()
    {
        flg=0;
    }
    synchronized void setData()
    {
        if(flg==0)
        {
            flg=1;
            try{
                wait();
            }
            catch(Exception e){}
        }
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){}
        data=(int)(Math.random()*100);
        notify();
    }
    synchronized void table()
    {
        if(flg==1)
        {
            notify();
        }
        else{
            flg=1;
        }
        
    try{
        wait();
    }
    catch(Exception e){}
    String s = "Table";
    for (int i=1;i<10;i++)
        s=s+" "+(data*i);

    System.out.println(s);  
    }
}

class CT1 extends Thread{      // It is consumer
    A11_Shared obj;
    CT1(A11_Shared obj)
    {
        super();
        this.obj=obj;
        start();
    }
    public void run()
    {
        obj.table();
    }
}

class CT2 extends Thread{       //producer
    A11_Shared obj;
    CT2(A11_Shared obj)
    {
        super();
        this.obj=obj;
        start();
    }
    public void run()
    {
        obj.setData();
    }
}

public class A13_Wait{
    public static void main(String [] args)
    {
        A11_Shared a=new A11_Shared();
        
        CT1 b = new CT1(a);
        CT2 c = new CT2(a);

        //if give call to CT2 and CT1 respectively



    }
}