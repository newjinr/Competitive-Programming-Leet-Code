package MaxWordsInSentence;

public class MaxWordsInSentence
{
    public MaxWordsInSentence()
    {
        String[] sentences = new String[]{};
        System.out.println(mostWordsFound(sentences));
    }

    public int mostWordsFound(String[] sentences)
    {
        int ans = 0;
        for (String sentence : sentences)
            ans = Math.max(sentence.split(" ").length, ans);

        return ans;
    }
}
