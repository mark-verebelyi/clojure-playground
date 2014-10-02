(ns zzz.crawler
  (:import (java.net URL))
  (:require [zzz.parser :as parser]))

(defn single-hashmark [href]
  (= href "#"))

(defn relative-href [href]
  (.startsWith href "/"))

(defn to-category [href]
  (cond
    (single-hashmark href) :single-hashmark
    (relative-href href) :relative-href
    :else :valid))

(defn categorize [hrefs]
  (group-by to-category hrefs))

(defn show [header list]
  (do
    (println header)
    (doseq [item list]
      (println (str "\t" item)))))

(defn crawl [url]
  (let [hrefs (parser/crawl url)
        categorized (categorize hrefs)]
    (do
      (show "single-hashmark" (categorized :single-hashmark))
      (show "relative-href" (categorized :relative-href))
      (show "valid" (categorized :valid)))))
