# TrainSort
火车跟进排序法，对比次数从 1 递增到 length - 1，<br />
呈直角三角形（冒泡排序、选择排序是长方形，每回对比次数固定），<br />
对比次数为 N(N-1)/2，远低于冒泡排序 N(N-1) 次，性能是冒泡排序的两倍！<br />
<br />

![](https://raw.githubusercontent.com/TommyLemon/StaticResources/master/TrainSort/TrainSort-Principle.jpg)   
![](https://raw.githubusercontent.com/TommyLemon/StaticResources/master/TrainSort/TrainSort-V2-NearTwicePerformanceOfBubbleSort.jpg)   

<br />
灵感来源于两列火车 A, B 相对行驶，从头对尾到头对头，<br />
可以让 A 每节车厢都和 B 所有车厢都依次正对，<br />
这样就覆盖了全部的正对组合情况。<br />
如果把火车映射为数组，车厢映射为数组元素，<br />
且两个数组一样，就能实现自身所有元素两两之间的对比（车厢正对）。<br />
<br />
性能有待继续对比测试，但理论上远超冒泡排序，<br >
而且它的特性和火车加速出站很像，<br />
或许还能用到启动时的机械嵌入式系统，<br />
又或许经过改进或者用它的思想去改进其它算法，能达到超过快排的效率。<br />
<br />
目前未找到业内已有同样的实现，如果有请告知我，<br />
可以是提 [Issue](https://github.com/TommyLemon/TrainSort/issues/new) 或发我 邮箱 tommylemon@qq.com，<br />
非常感谢！<br />
