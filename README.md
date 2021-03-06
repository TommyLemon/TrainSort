# TrainSort
火车跟进排序算法，对比次数从 1 递增到 length - 1，<br />
对比次数为 N(N-1)/2，是类似冒泡排序的一种交换排序，<br />
比较元素从相邻（j 和 j+1）变成了下标逐渐靠近（0 和 length - 1 至 length - 2 和 length - 1）。<br />
<br />

以下图中关于冒泡排序的说明有误，只有最差的冒泡排序才是 N(N-1) ，减少了重复对比的冒泡排序也是 N(N-1)/2。
![](https://raw.githubusercontent.com/TommyLemon/StaticResources/master/TrainSort/TrainSort-Principle.jpg)   
![](https://raw.githubusercontent.com/TommyLemon/StaticResources/master/TrainSort/TrainSort-V2-NearTwicePerformanceOfBubbleSort.jpg)   

<br />
灵感来源于两列火车 A, B 相对行驶，从 头对尾 到 尾对头，<br />
可以让 A 每节车厢都和 B 所有车厢都依次正对，<br />
这样就覆盖了全部的正对组合情况。<br />
如果把火车映射为数组，车厢映射为数组元素，<br />
且两个数组一样，就能实现自身所有元素两两之间的对比（车厢正对）。<br />
最早取名为 火车交错排序算法，后面发现没必要对齐后再超过 length 来继续对比，<br />
直接从 头对尾 到 并列减一，也就是 1 至 length - 1，<br />
即可覆盖全部组合情况，并且对比次数减半，<br />
所以改名为 火车跟进排序算法。 <br />
<br />

<br />
性能有待继续对比测试，但经过实测已是和冒泡排序一致。<br >
但它的特性和火车加速出站很像，<br />
或许能用到启动时的机械嵌入式系统，<br />
又或许经过改进或者用它的思想去改进其它算法，能达到超过快排的效率。<br />
<br />
目前未找到业内已有同样的实现，如果有请告知我，<br />
或者如果本项目中有任何错误敬请指正，<br />
可以是 [提ISSUE](https://github.com/TommyLemon/TrainSort/issues/new) 或发我 邮箱 tommylemon@qq.com，<br />
非常感谢！<br />
