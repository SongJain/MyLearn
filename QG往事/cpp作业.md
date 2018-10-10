                       物联网三班  宋健  3117001515

```
#include <iostream>
using namespace std;
int main()
{
   int i; int n;
   cout<<"请输入数字个数：";
   cin>>n;
   int a[n];
   int sum=0; 
   cout<<"数字为:";
   for(i=0;i<n;i++)
    {
	    cin>>a[i];
	    sum=sum+a[i]; 
    } 
   for(int k=i;k>0;k--)
        cout<<a[k-1]<<"  ";
    cout<<"sum="<<sum;
} 
```

```
#include<iostream>
using namespace std;
int main()
{
	int a,n;
	int sum=0;
	int k;
	cout<<"请输入数字：";
	cin>>a;
	cout<<"请输入数字个数：";
	cin>>n;
	for(int i=0;i<n;i++)
	{   
	    if(i==0)
	    {
	    	k=a;
	    	sum+=k;
		}
		else
		{
			k=k*10+a;
			sum+=k;
		}
	} 
	cout<<"sum="<<sum; 
}
```

```
#include<iostream>
using namespace std;
int jud(int n);
int main()
{
	int sum=0;
	for(int i=100;i<=230;i++)
		if(jud(i))
		{
			sum+=i;
		}
	cout<<"sum="<<sum;
}
int jud(int n)
{
    for (int k=2;k<n;k++)
	{
		if(n%k==0)
		{
			return 0;
		}
	}	
}
```
```
#include<iostream>
using namespace std;
int main()
{
	int a;
	cout<<"请输入学生成绩：";
	cin>>a;
	if(a<=100&&a>90) 
	cout<<"excellent";
	if(a<=90&&a>80) 
	cout<<"good";
	if(a<=80&&a>70) 
	cout<<"general";
	if(a<=70&&a>60) 
	cout<<"pass";
	if(a<60) 
	cout<<"not pass";
}
```
```
#include<iostream>
using namespace std;
int main()
{
	int n,sum=1;
	cout<<"输入n：";
	cin>>n;
	if(n==0)
	cout<<1;
	else
	{
		for(int i=1;i<=n;i++)
		{
			sum*=i;
		}
	}
	cout<<sum;
}
```

```
#include<iostream>
using namespace std;
int main()
{
	int n,k,sum=1;
	cout<<"输入n：";
	cin>>n;
	if(n==0)
	cout<<1;
	else
	{
		for(int i=1;i<=n;i++)
		{
			sum*=i;
			k+=sum;
		}
	}
	cout<<k;
}
```

```
#include<iostream>
using namespace std;
int main()
{
	int a,b,c,t;
	cout<<"输入三个数：";
	cin>>a>>b>>c;
    if(a>b)  
    {  
        t=a;  
        a=b;  
        b=t;  
    }  
    if(a>c)  
    {  
        t=a;  
        a=c;  
        c=t;  
    }  
    if(b>c)  
    {  
        t=b;  
        b=c;  
        c=t;  
    }  
	cout<<a<<b<<c; 
}
```

```
#include<iostream>
using namespace std;
int main()
{
	int i=100;
	for(i;i<=200;i++)
	    if(i%3==2&&i%5==3&&i%7==2)
	        cout<<i;
}
```

```
#include<iostream>
using namespace std;
int main()
{
	 int i,j;
    for(int i=1,j=1;j<=9;i++)
	{
        cout<<" "<<i<<"*"<<j<<"="<<i*j;
        if(i==j)
		{
            i=0;
            j++;
            cout<<endl;
        }
    }
}
```

```
#include<iostream>
using namespace std;
int main()
{
	int i=1;
	while(i<10)
	{
	    int j=1;
	    while(j<=i)
	    {
	        cout<<" "<<i<<"*"<<j<<"="<<i*j;
	        j++;
	    }
	    cout<<endl;
	    i++;
	}
}
```

```
#include<iostream>
using namespace std;
int main()
{
	int i=1, j=1;
	 do{j=1;
		do{cout<<" "<<i<<"*"<<j<<"="<<i*j;
			j++;
	    	}while(j<=i);
		i++;
		cout<<endl;
		}while(i<=9);
}
```

```
#include<iostream>
using namespace std;
int main()
{
	float a,b;
	char k;
	cout<<"输入两个浮点数"<<endl;
	cout<<"输入第一个浮点数:";
	cin>>a;
	cout<<"\n输入第二个浮点数:"; 
	cin>>b;
	cout<<"运算符为：";
	cin>>k;
	switch(k)
	{
		case '+': cout<<a+b;break;
		case '-': cout<<a-b;break;
		case '*': cout<<a*b;break;
		case '/': cout<<a/b;break;
		default :cout<<"wrong!!!!";
	}
}

```
                            
