package ru.kpn.objectFactory.results.builder;

import ru.kpn.objectFactory.results.result.Result;

public interface ResultBuilder<V, S> {
    default ResultBuilder<V, S> check(){return this;}
    default ResultBuilder<V, S> calculateValue(){return this;}
    Result<V, S> buildResult();
}