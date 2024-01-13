package SimplifyPath;

import java.util.Stack;

public class SimplifyPath
{
    public SimplifyPath()
    {
        String path = "/newjin////newjin.txt/.../.";
        System.out.println(simplifyPath(path));
    }

    public String simplifyPath(String path)
    {
        String[] splittedPath = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder simplifiedPath = new StringBuilder();

        for(String pathName : splittedPath)
        {
            if(pathName.equals(".."))
            {
                if(!stack.isEmpty()) stack.pop();
                continue;
            }
            if(pathName.equals(".") || pathName.length() == 0) continue;
            stack.push(pathName);
        }

        while (!stack.isEmpty())
        {
            simplifiedPath.insert(0, stack.pop());
            simplifiedPath.insert(0, "/");
        }

        return simplifiedPath.toString().length() == 0 ? "/" : simplifiedPath.toString();
    }
}
