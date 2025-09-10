package story;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Historia {
    public String cenaInicialId;
    public List<Cena> cenas;
    private transient Map<String, Cena> mapaDeCenas;

    public Cena getCena(String id) {
        if (mapaDeCenas == null) {
            mapaDeCenas = cenas.stream()
                               .collect(Collectors.toMap(c -> c.id, Function.identity()));
        }
        return mapaDeCenas.get(id);
    }
}