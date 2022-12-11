<blockquote> 
 <p><a href="https://so.csdn.net/so/search?q=%E4%BA%8C%E5%8F%89%E6%A0%91&amp;spm=1001.2101.3001.7020" target="_blank" class="hl hl-1" data-report-click="{&quot;spm&quot;:&quot;1001.2101.3001.7020&quot;,&quot;dest&quot;:&quot;https://so.csdn.net/so/search?q=%E4%BA%8C%E5%8F%89%E6%A0%91&amp;spm=1001.2101.3001.7020&quot;,&quot;extra&quot;:&quot;{\&quot;searchword\&quot;:\&quot;二叉树\&quot;}&quot;}" data-tit="二叉树" data-pretit="二叉树">二叉树</a>也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，并且我们用值-1代表一个节点为空。</p> 
 <p>给定一个数组存储的二叉树，试求从根节点到最小的<a href="https://so.csdn.net/so/search?q=%E5%8F%B6%E5%AD%90%E8%8A%82%E7%82%B9&amp;spm=1001.2101.3001.7020" target="_blank" class="hl hl-1" data-report-click="{&quot;spm&quot;:&quot;1001.2101.3001.7020&quot;,&quot;dest&quot;:&quot;https://so.csdn.net/so/search?q=%E5%8F%B6%E5%AD%90%E8%8A%82%E7%82%B9&amp;spm=1001.2101.3001.7020&quot;,&quot;extra&quot;:&quot;{\&quot;searchword\&quot;:\&quot;叶子节点\&quot;}&quot;}" data-tit="叶子节点" data-pretit="叶子节点">叶子节点</a>的路径，路径由节点的值组成。</p> 
 <p><strong>输入描述</strong><br> 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。<br> 注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。<br> 输入的树最多为7层。<br><strong>输出描述</strong><br> 输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。</p> 
 <p><strong>示例 1：</strong><br> 输入<br> 3 5 7 -1 -1 2 4<br> 输出<br> 3 7 2<br> 说明<br> 最小叶子节点的路径为3 7 2</p> 
 <p><strong>示例 2：</strong><br> 输入<br> 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6<br> 输出<br> 5 8 7 6<br> 说明<br> 最小叶子节点的路径为5 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1</p> 
 <p><img alt="" src="https://img-blog.csdnimg.cn/d9fb087afbed4094ba1042d27a375156.png"></p> 
 <p></p> 
</blockquote>
思路：
<blockquote> 
 <p>1：树的递归操作，先找到最小的根节点，注意二叉树是用数组表示的，用 2N和2N+1来表示左右子树。</p> 
 <p>2：然后根据这个根节点去推导路径</p> 
</blockquote>