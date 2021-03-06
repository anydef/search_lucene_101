package de.otto.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@JsonDeserialize
@Value
@RequiredArgsConstructor(staticName = "of")
public class SearchResult {
    String queryTerm;

    Long numberFound;

    List<SearchDocument> documents = new ArrayList<>();

    public List<SearchDocument> addDocument(final SearchDocument searchDocument) {
        documents.add(searchDocument);
        documents.sort(Comparator.comparingInt(SearchDocument::getRank));
        return documents;
    }
}
