#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n, x;
    char com[20];
    list<int> lt;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%s", com);
        scanf("%d", &x);
        if (com[0] == 'i')
        {
            lt.push_front(x);
        }
        else
        {
            if (strlen(com) > 6)
            {
                if (com[6] == 'F')
                    lt.pop_front();
                else
                    lt.pop_back();
            }
            else
            {
                for (list<int>::iterator it = lt.begin(); it != lt.end(); it++)
                {
                    if (*it == x)
                    {
                        lt.erase(it);
                        break;
                    }
                }
            }
        }
    }
    int i = 0;
    for (list<int>::iterator it = lt.begin(); it != lt.end(); it++)
    {
        if (i > 0)
            printf(" ");
        printf("%d", *it);
    }
    printf("\n");
}