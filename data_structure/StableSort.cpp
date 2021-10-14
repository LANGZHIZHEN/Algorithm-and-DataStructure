#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct Card
{
    char suit, value;
};
void bubble(Card c[], int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = n - 1; j >= i; j--)
        {
            if (c[j].value < c[j - 1].value)
            {
                swap(c[j], c[j - 1]);
            }
        }
    }
}
void selection(Card c[], int n)
{
    for (int i = 0; i < n; i++)
    {
        int index = i;
        for (int j = i; j < n; j++)
        {
            if (c[j].value < c[index].value)
            {
                index = j;
            }
        }
        swap(c[i], c[index]);
    }
}
void print(Card c[], int n)
{
    for (int i = 0; i < n; i++)
    {
        if (i > 0)
            printf(" ");
        cout << c[i].suit << c[i].value;
    }
    printf("\n");
}
bool isStable(Card c1[], Card c2[], int n) //稳定排序即当两个比较元素相同时，最终排序是按照输入的顺序排序的。
{                                          //即当排序不会改变原相同元素之间的顺序
    for (int i = 0; i < n; i++)
    {
        if (c1[i].suit != c2[i].suit)
            return false;
    }
    return true;
}
int main()
{
    int n;
    Card c1[100], c2[100];
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        cin >> c1[i].suit >> c1[i].value;
        c2[i] = c1[i];
    }
    bubble(c1, n);
    selection(c2, n);
    print(c1, n);
    printf("Stable\n"); //冒泡排序一定是稳定排序
    print(c2, n);
    if (isStable(c1, c2, n)) //选择排序不一定是稳定的
        printf("Stable\n");
    else
        printf("Not stable\n");
}