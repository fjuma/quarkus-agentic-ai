package org.agenticai.searchastool;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;
import io.quarkiverse.langchain4j.ReActAgent;

@RegisterAiService(modelName = "granite-instruct")
public interface IntelligentAgent {

    @SystemMessage("""
        You are a chatbot, and you need to answer questions asked by the user.
        Perform a web search for information that you don't know and use the result to answer to the initial user's question.
    """)
    @ReActAgent
    @ToolBox({WebSearchService.class})
    String chat(String question);

}
