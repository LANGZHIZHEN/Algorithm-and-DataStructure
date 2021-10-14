// #include <bits/stdc++.h>
// using namespace std;
// struct Task
// {
//     string name;
//     int time;
//     bool state;
// };
// const int LEN = 1e6 + 5;
// Task tk[LEN];
// int head, tail;
// Task dequeue()
// {
//     Task item = tk[head];
//     head = (head + 1) % LEN;
//     return item;
// }
// void enqueue(Task t)
// {
//     tk[tail] = t;
//     tail = (tail + 1) % LEN;
// }
// int main()
// {
//     int n, slice;
//     scanf("%d %d", &n, &slice);
//     for (int i = 0; i < n; i++)
//     {
//         cin >> tk[i].name >> tk[i].time;
//     }
//     head = 0;
//     tail = n;
//     int Time = 0;
//     int cur_time = 0;
//     while (head != tail)
//     {
//         Task t = dequeue();
//         cur_time = min(t.time, slice);
//         t.time -= cur_time;
//         Time += cur_time;
//         if (t.time > 0)
//             enqueue(t);
//         else
//             cout << t.name << " " << Time << endl;
//     }
// }
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n, slice, Time, t, p;
    string name;
    queue<pair<string, int>> task;
    cin >> n >> slice;
    for (int i = 0; i < n; i++)
    {
        cin >> name >> t;
        task.push(make_pair(name, t));
    }
    pair<string, int> cur_task;
    while (!task.empty())
    {
        cur_task = task.front();
        p = min(cur_task.second, slice);
        cur_task.second -= p;
        Time += p;
        if (cur_task.second > 0)
        {
            task.push(cur_task);
        }
        else
        {
            cout << cur_task.first << " " << Time << endl;
        }
    }
    return 0;
}