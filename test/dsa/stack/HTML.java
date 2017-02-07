package dsa.stack;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import dsa.stack.Stack;
import dsa.stack.StackList;

/**
  HTML 是 Internet 超文本的标准格式。按照规范，HTML 文档由不同的标志(Tag)划分为不同 的部分与层次。与括号类似，这些标志也需成对出现，对于名为<myTag>的起始标志，相应的结束 标志为</myTag>。常用的 HTML 标志有:
  <body>和</body>:文档体
  <h1> 和</h1>:节的头部
  <center> 和</center>:居中对齐
  <left>和</left>:左对齐
  <p> 和</p>:段落
  <ol> 和</ol>:编号列表
  <li> 和</li>:列表项 
  
 * @author shichaopeng
 *
 */

public class HTML {

	public static class Tag {
		String name;
		boolean opening;

		public Tag() {
			name = "";
			opening = false;
		}

		public Tag(String name, boolean opening) {
			this.name = name;
			this.opening = opening;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isOpening() {
			return opening;
		}

		public void setOpening(boolean opening) {
			this.opening = opening;
		}

	}

	private void indent(int level) {
		for (int k = 0; k < level; k++) {
			System.out.println("\t | ");
		}
	}

	public boolean isHTMLMatched(Tag[] tags) {
		int level = 0;
		Stack stack = new StackList();
		for (int i = 0; i < tags.length && tags[i] != null; i++) {
			Tag item = tags[i];
			if (item.isOpening()) {
				stack.push(item.getName());
				indent(level++);
				System.out.println("\t┌" + item.getName());
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (!((String) stack.pop()).equals(item.getName())) {
					return false;
				}
				indent(level--);
				System.out.println("\t└" + item.getName());
			}
		}
		return stack.isEmpty();
	}

	public Tag[] parseHTML(BufferedReader bufferedReader) throws IOException {
		String line;
		boolean inTag = false;
		Tag[] tags = new Tag[2048];
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			StringTokenizer stringTokenizer = new StringTokenizer(line, "<> \t", true);
			while (stringTokenizer.hasMoreTokens()) {
				String token = stringTokenizer.nextToken();
				if (token.equals("<"))
					//若扫描到'<'，说明遇到了下一标志，故将当前状态设为"正在扫描标志"
					inTag = true;
				else if (token.equals(">"))
					//若扫描到'>'，说明上一标志扫描完毕，故将当前状态设为"处于标志之外"
					inTag = false;
				else if (inTag) {
					//若正在扫描一个标志
					if ((token.length() == 0) || (token.charAt(0) != '/')) {
						tags[count++] = new Tag(token, true);
					} else {
						//加入一个结束标志(跳过首字符'/')
						tags[count++] = new Tag(token.substring(1), false);
					}
				}
			}
		}
		return tags;
	}

	public static void main(String[] args) throws IOException {
		String str = "<body><left> <h1>数据结构与算法</h1> <p> 程序=数据结构+算法 </p><ol> <li>线性结构</li> <li>半线性结构</li> <li>非线性结构</li> </ol></left></body>";
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		// new InputStreamReader(System.in)
		BufferedReader stdr = new BufferedReader(new InputStreamReader(is));// 标准输入
		HTML tagChecker = new HTML();
		if (tagChecker.isHTMLMatched(tagChecker.parseHTML(stdr)))
			System.out.println("该文件符合HTML的标志匹配");
		else
			System.out.println("该文件不符合HTML的标志匹配");
	}

}
