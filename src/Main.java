import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Uso: java -jar cli.jar analyze --depth <n> \"{phrase}\" [--verbose]");
            return;
        }

        String phrase = args[3];
        int depth = Integer.parseInt(args[2]);

        long startLoadTime = System.currentTimeMillis();
        HierarchyLoader loader = new HierarchyLoader("dicts/dict.json");
        Map<String, Object> hierarchy = loader.getHierarchy();
        long endLoadTime = System.currentTimeMillis();

        long startAnalyzeTime = System.currentTimeMillis();
        PhraseAnalyzer analyzer = new PhraseAnalyzer(hierarchy);
        Map<String, Integer> result = analyzer.analyzePhrase(phrase, depth);
        long endAnalyzeTime = System.currentTimeMillis();

        // Exibir o resultado da análise
        if (result.isEmpty()) {
            System.out.println("Nenhuma correspondência encontrada no nível " + depth);
        } else {
            AtomicInteger index = new AtomicInteger();
            result.forEach((key, count) -> {
                if (index.get() != result.size() - 1)
                    System.out.print(key + " = " + count + "; ");
                else
                    System.out.println(key + " = " + count);
                index.getAndIncrement();
            });
        }

        // Exibir métricas se verbose for especificado
        if (args.length > 4 && "--verbose".equals(args[4])) {
            System.out.println("Tempo de carregamento dos parâmetros: " + (endLoadTime - startLoadTime) + "ms");
            System.out.println("Tempo de verificação da frase: " + (endAnalyzeTime - startAnalyzeTime) + "ms");
        }
    }
}
