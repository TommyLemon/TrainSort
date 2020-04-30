# TrainSort
火车交错排序法，对比次数从 0 递增到 length，再从 length 递减到 0，<br />
呈等腰三角形（冒泡排序、选择排序是长方形，每回对比次数固定）。<br />
<br />
性能有待继续对比测试，但理论上次数比选择、插入排序慢，<br >
而且因为两头未重叠的车厢多余出来的对比次数，性能甚至可能比不上冒泡，<br />
但它的特性和火车加速出站到减速进站很像，或许能用到需要变速操作的机械嵌入式系统。<br />
<br />
目前未找到业内已有同样的实现，如果有请告知我，<br />
可以是提 [Issue](https://github.com/TommyLemon/TrainSort/issues/new) 或发我 邮箱 tommylemon@qq.com，<br />
非常感谢！<br />
