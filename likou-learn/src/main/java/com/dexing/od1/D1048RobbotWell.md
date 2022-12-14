<blockquote> 
 <p>机器人走一个迷宫，给出迷宫的x和y(x*y的迷宫)并且迷宫中有障碍物,输入k表示障碍物有k个，并且会将障碍物的坐标挨个输入。</p> 
 <p>机器人从0,0的位置走到x,y的位置并且只能向x,y增加的方向走，不能回退，</p> 
 <p>如代码类注释展示的样子，#表示可以走的方格，0代表障碍，机器人从0,0的位置只能向下或者向前走到出口，</p> 
 <p>其中会有不可达方格和陷阱方格。</p> 
 <p>不可达方格为第四行前三个，该机器人在行走路径上不可能走到的方格，陷阱方格如第一行最后两个，走进之后则不能抵达终点。</p> 
 <p><img alt="" height="460" src="https://img-blog.csdnimg.cn/9f54cfe74709482ca23ec88b1591e564.png" width="773"></p> 
 <p>&nbsp;</p> 
 <p>要求: 输出陷阱和不可达方格方格数量。</p> 
 <p><strong>输入描述：</strong></p> 
 <p>1）第一行为房间的X 和Y （0&lt;=X/Y &lt;=1000）</p> 
 <p>2) &nbsp;第二行为房间中的墙壁障碍物个数 N，0&lt;= N &lt;=X*Y ）</p> 
 <p>3) &nbsp;接下来会有N行墙壁的坐标，同一行中若有多个障碍物，以空格隔开，所有数据输入均合法。</p> 
 <p><strong>输出描述：</strong></p> 
 <p>陷阱方格与不可达方格数量，以空格隔开。</p> 
 <p><strong>示例1：</strong></p> 
 <p>输入：</p> 
 <p>6 4</p> 
 <p>5</p> 
 <p>0 2</p> 
 <p>1 2</p> 
 <p>2 2</p> 
 <p>4 1</p> 
 <p>5 1</p> 
 <p>输出：</p> 
 <p>2 3</p> 
</blockquote>

思路：
<blockquote> 
 <p>1：典型的路径问题，DFS即可解决。（也有用动态规划的，我觉的不好想出来）</p> 
 <p>2：设置方格的状态，0为不可达，1为障碍物，2为可达到，3为陷阱。</p> 
 <p>3：先按照输入将固定位置上置为1，然后从左下角开始走即可。</p> 
 <p>深度优先遍历图的方法是，从图中某顶点v出发：</p> 
 <p>（1）访问顶点v；</p> 
 <p>（2）依次从v的未被访问的邻接点出发，对图进行深度优先遍历；直至图中和v有路径相通的顶点都被访问；</p> 
 <p>（3）若此时图中尚有顶点未被访问，则从一个未被访问的顶点出发，重新进行深度优先遍历，直到图中所有顶点均被访问过为止。</p> 
</blockquote>