package org.example;

// Klavyeden girilen N elemanlı A dizisini küçükten büyüğe doğru "Birleştirme Sıralama (merge sort)"
// algoritmasıyla sıralayan program

import java.util.Scanner;

public class Main {

    public static void birlestir(int[] a, int p,int r,int s,int t, int es){

        int k,l,m;
        int[] g = new int[es];
        k=p;
        l=s;
        m = 0;

        while (k<=r && l<=t){
         if (a[k]<a[l])
             g[m++]=a[k++];
         else
             g[m++]=a[l++];
        }
        while (k<=r)
            g[m++]=a[k++];
        while (l<=t)
            g[m++]=a[l++];
           for (k=p,l=0; k<=t; k++,l++)
               a[k]=g[l];
    }

    public static void birlestirmeSiralama(int[] a,int x,int y,int es){

        int orta;

        if (x<y){
            orta=(x+y)/2;
            birlestirmeSiralama(a, x, orta, es);
            birlestirmeSiralama(a,orta+1, y, es);
            birlestir(a,x,orta,orta+1,y,es);
        }
    }

    public static void main(String[] args) {

        int i,n;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDizinin Eleman Sayısı : ");
        n = scanner.nextInt();
        int[] a = new int[n];

        for (i=0; i<n; i++){
            System.out.print("Dizinin "+(i)+". Elemanı : ");
            a[i] = scanner.nextInt();
        }

        birlestirmeSiralama(a,0,n-1,n);
        System.out.print("\nSıralı Dizi : \n------------\n");
        for (i=0; i<n; i++)
            System.out.printf("%d\t",a[i]);
    }
}