#include<iostream>
#include<stdio.h>
#include<conio.h>
#include<fstream>
using namespace std;
//=========================================
int n,s,t;
char chon;
int truoc[100],d[100],cp[100][100];
int daxet[100];
//==========================================
void init()
{
     fstream fi("matran.txt",ios::in);
     fi>>n;
     if(!fi)
     {
       cout<<"Ko thay file input";
       return;
             }
      cout<<"so dinh: "<<n;
      cout<<"\nMa tran ke: ";
      for(int i=1;i<=n;i++)
      {
        cout<<"\n";
        for(int j=1;j<=n;j++)
        {
           fi>>cp[i][j];
           cout<<cp[i][j]<<" ";
           if(cp[i][j]==0) cp[i][j]=32000;
                }                
              }
        fi.close();
 }
//=============================================
void result()
{
     int i,j;
     cout<<"\nDuong di ngan nhat tu "<<s<<"den "<<t<<"la:";
     cout<<t<<"<-";
     i=truoc[t];
     while(i!=s)
     {
       cout<<i<<"<-";
       i=truoc[i];
     }
     cout<<s;
     cout<<"\nDo dai duong di la: "<<d[t];
     //getch();
 }
//=============================================
void Dijkstra()
{
     int v,u,minp;
     cout<<"\nTim duong di tu s=";
     cin>>s;
     cout<<"den ";
     cin>>t;
     for(int i=1;i<=n;i++)
     {
        d[i]=cp[s][i];
        truoc[i]=s;
        daxet[i]=0;
     }
     //tim ra cac dinh gan s-->xem dinh nao co trong so be nhat, gan cho truoc v=s
     truoc[s]=0; d[s]=0; daxet[s]=1;
     while(!daxet[t]) //chay den khi nao gap dinh t la dinh can den
     {
       minp=2000;
       for(int i=1;i<=n;i++)
       {
         if((!daxet[i])&&(minp>d[i]))
         {
           u=i;
           minp=d[i];
         }
       }//tim ra dinh gan s co trong so be nhat la u
       daxet[u]=1;
       if(!daxet[t])
       {
         for(int i=1;i<=n;i++)
         {
            if((!daxet[i])&&(d[u]+cp[u][i]<d[i])) //co duong di tu s->i qua u
            {
               d[i]=d[u]+cp[u][i];
               truoc[i]=u;
            }
         }
       }
     }
 }
//=============================================
int main()
{
    init();
    Dijkstra();
    result();
    getch();
}

