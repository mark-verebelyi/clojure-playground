(ns zzz.parser
  (:import (java.net URL))
  (:require [net.cgrand.enlive-html :as html-parser]))

(defn- fetch-html [url]
  (html-parser/html-resource (URL. url)))

(defn- parse-anchors [html]
  (html-parser/select html [[:a (html-parser/attr? :href)]]))

(defn- parse-attrs [anchors]
  (map :attrs anchors))

(defn- parse-hrefs [attrs]
  (map :href attrs))

(defn crawl [url]
  (let [html (fetch-html url)
        anchors (parse-anchors html)
        attrs (parse-attrs anchors)
        hrefs (parse-hrefs attrs)]
    hrefs))