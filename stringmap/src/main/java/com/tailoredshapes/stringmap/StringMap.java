package com.tailoredshapes.stringmap;

import com.tailoredshapes.underbar.Dates;
import com.tailoredshapes.underbar.Strings;
import com.tailoredshapes.underbar.UnderBar;
import org.joda.time.DateTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.tailoredshapes.underbar.Dates.isoString;
import static com.tailoredshapes.underbar.Die.*;
import static com.tailoredshapes.underbar.Strings.urlEncode;
import static com.tailoredshapes.underbar.UnderBar.*;
import static java.util.Optional.ofNullable;
import static org.joda.time.format.ISODateTimeFormat.dateTimeParser;

public class StringMap implements JSONAware {
    private final Map<String, Object> m = new HashMap<>();

    public StringMap(Map<String, ?> m) {
        forEach(m, this::put);
    }

    public StringMap() {
    }

    public StringMap(StringMap m) {
        this(m.m);
    }

    public static <T> StringMap smapFromPairs(Iterable<T> ts, Function<T, Map.Entry<String, Object>> toEntry) {
        return new StringMap(mapFromPairs(ts, toEntry));
    }

    public static <V> StringMap smapFromKeys(Iterable<String> ks, Function<String, V> toV) {
        return smapFromPairs(ks, k -> entry(k, toV.apply(k)));
    }

    public static List<StringMap> parseJsonMaps(String path) {
        return parseJsonMaps(Paths.get(path));
    }

    public static List<StringMap> parseJsonMaps(Path path) {
        String jsonString = rethrow(() -> new String(Files.readAllBytes(path)));
        JSONArray items = (JSONArray) rethrow(() -> JSONValue.parseWithException(jsonString));
        return UnderBar.map(items, i -> new StringMap(((HashMap<String, Object>) i)));
    }

    public static StringMap parseJSON(String json) {
        return new StringMap((Map<String, Object>) dieIfNull(JSONValue.parse(json), () -> "error parsing JSON: " + json));
    }

    public static StringMap parseJSON(Path path) {
        return parseJSON(rethrow(() -> new String(Files.readAllBytes(path))));
    }

    public static StringMap smap() {
        return new StringMap();
    }

    public static StringMap smap(String k1, Object v1) {
        return smap().put(k1, v1);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2) {
        return smap(k1, v1).put(k2, v2);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        return smap(k1, v1, k2, v2).put(k3, v3);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4) {
        return smap(k1, v1, k2, v2, k3, v3).put(k4, v4);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4).put(k5, v5);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5).put(k6, v6);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6).put(k7, v7);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7).put(k8, v8);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8).put(k9, v9);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9).put(k10, v10);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10).put(k11, v11);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11).put(k12, v12);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12).put(k13, v13);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13).put(k14, v14);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14).put(k15, v15);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15, String k16, Object v16) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15).put(k16, v16);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15, String k16, Object v16, String k17, Object v17) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16).put(k17, v17);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15, String k16, Object v16, String k17, Object v17, String k18, Object v18) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17).put(k18, v18);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15, String k16, Object v16, String k17, Object v17, String k18, Object v18, String k19, Object v19) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18).put(k19, v19);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15, String k16, Object v16, String k17, Object v17, String k18, Object v18, String k19, Object v19, String k20, Object v20) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19).put(k20, v20);
    }

    public static StringMap smap(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, String k11, Object v11, String k12, Object v12, String k13, Object v13, String k14, Object v14, String k15, Object v15, String k16, Object v16, String k17, Object v17, String k18, Object v18, String k19, Object v19, String k20, Object v20, String k21, Object v21) {
        return smap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19, k20, v20).put(k21, v21);
    }

    public StringMap put(String k, Object v) {
        if (v == null || v.equals(""))
            m.put(k, null);
        else
            m.put(k, v);
        return this;
    }

    public long size() {
        return m.size();
    }

    public StringMap with(String k, Object v) {
        return new StringMap(this).put(k, v);
    }

    public long long_(String k) {
        return getCast(k, t -> (long) t);
    }

    public double double_(String k) {
        return ((Number) getCast(k, x -> (Number) x)).doubleValue();
    }

    public int integer(String k) {
        return getCast(k, x -> (int) x);
    }

    public int integer(String k, int default_) {
        Integer result = (Integer) m.getOrDefault(k, default_);
        return result == null ? default_ : result;
    }

    public int integerValue(String k) {
        Number value = getCast(k, x -> (Number) x);
        return tap(value.intValue(), result ->
                dieUnless(result == value.longValue(), () -> "overflow detected!  cannot convert " + value + " to integer"));
    }

    public int parseInteger(String k, int default_) {
        return ofNullable((String) m.get(k)).map(Integer::parseInt).orElse(default_);
    }

    public long parseLong(String key, long default_) {
        return ofNullable((String) m.get(key)).map(Long::parseLong).orElse(default_);
    }

    public Optional<Integer> integerMaybe(String k) {
        return getCast(k, x -> (Optional<Integer>) x);
    }

    public Optional<DateTime> dateMaybe(String k) {
        return getCast(k, x -> (Optional<DateTime>) x);
    }

    public Optional<Double> doubleMaybe(String k) {
        return getCast(k, x -> (Optional<Double>) x);
    }

    public Optional<Long> longMaybe(String key) {
        return getCast(key, x -> (Optional<Long>) x);
    }

    public Optional<Boolean> boolMaybe(String key) {
        return getCast(key, x -> (Optional<Boolean>) x);
    }

    public long longValue(String k) {
        return ((Number) getCast(k, x -> (Number) x)).longValue();
    }

    public String string(String k) {
        return getCast(k, x -> (String) x);
    }

    public Optional<String> stringMaybe(String k) {
        return getCast(k, x -> (Optional<String>) x);
    }

    public DateTime date(String k) {
        return getCast(k, x -> (DateTime) x);
    }

    public <T> List<T> map(BiFunction<String, Object, T> toT) {
        return UnderBar.map(m, toT);
    }

    public Map<String, Object> putInto(Map<String, Object> other) {
        other.putAll(m);
        return other;
    }

    public StringMap putInto(StringMap other) {
        other.m.putAll(m);
        return other;
    }

    public boolean has(String key) {
        return m.containsKey(key);
    }

    public boolean hasValue(String key) {
        return has(key) && m.get(key) != null && (m.get(key) instanceof Optional ? ((Optional) m.get(key)).isPresent() : true);
    }

    public boolean bool(String k) {
        return getCast(k, b -> (boolean) b);
    }

    public boolean bool(String key, boolean default_) {
        return (Boolean) m.getOrDefault(key, default_);
    }

    private <T> T getCast(String k, Function<T, T> onT) {
        Object value = dieIfMissing(m, k);
        return rethrow(() -> onT.apply((T) value), () -> "failed to cast to T for key: " + k + ": value: " + value + " of type: " + value.getClass());
    }

    public StringMap smap(String k) {
        return getCast(k, smap -> (StringMap) smap);
    }

    public StringMap makeSmap(String key) {
        return new StringMap((Map<String, Object>) getCast(key, x -> x));
    }

    public List<StringMap> smaps(String key) {
        return getCast(key, x -> (List<StringMap>) x);
    }

    public List<StringMap> makeSmaps(String key) {
        return UnderBar.map((Collection<Map<String, Object>>) getCast(key, x -> (Collection<Map<String, Object>>) x), StringMap::new);
    }

    public StringMap parseJson(String key) {
        return parseJSON(string(key));
    }

    @Override
    public String toJSONString() {
        return JSONValue.toJSONString(modifyValues(m, this::toJSONStringValue));
    }

    private Object toJSONStringValue(Object v) {
        if (v instanceof Optional<?>) return toJSONStringValue(((Optional<?>) v).orElse(null));
        if (v instanceof DateTime) return isoString((DateTime) v);
        if (v instanceof UUID) return v.toString();
        if (v instanceof Map) return new StringMap((Map<String, Object>) v).toJSONString();
        return v;
    }

    @Override
    public String toString() {
        return new TreeMap<>(m).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringMap stringMap = (StringMap) o;
        if (!m.keySet().equals(stringMap.m.keySet())) return false;
        for (String k : m.keySet()) {
            Object lvalue = m.get(k);
            Object rvalue = stringMap.m.get(k);
            if (((lvalue instanceof Integer && rvalue instanceof Long) || (lvalue instanceof Long && rvalue instanceof Integer))) {
                // they are all longs to JSON, so we don't want to get bogged down in chasing down int v. long issues
                if (((Number) lvalue).longValue() != ((Number) rvalue).longValue())
                    return false;
            } else if ((lvalue instanceof Double) && (rvalue instanceof Double)) {
                if (!almostEqual((Double) lvalue, (Double) rvalue))
                    return false;
            } else if (!java.util.Objects.equals(lvalue, rvalue))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(m);
    }

    public StringMap filterKeys(Predicate<String> predicate) {
        return new StringMap(UnderBar.filterKeys(m, predicate));
    }

    public StringMap rejectKeys(String... keys) {
        return rejectKeys(list(keys));
    }

    public StringMap selectKeys(String... keys) {
        Set<String> keySet = set(keys);
        return filterKeys(keySet::contains);
    }

    public StringMap selectKeys(Iterable<String> keys) {
        Set<String> keySet = set(keys);
        return filterKeys(keySet::contains);
    }

    public StringMap rejectKeys(List<String> keys) {
        Set<String> keySet = set(keys);
        return filterKeys(k -> !keySet.contains(k));
    }

    public Map<String, Object> toMap() {
        return new HashMap<>(m);
    }

    public Map<String, Object> toMapDeeply() {
        Map<String, Object> result = toMap();

        result.forEach((key, value) -> {
            if (value instanceof StringMap) {
                result.put(key, ((StringMap) value).toMapDeeply());
            } else if (value instanceof Iterable<?>) {
                Iterable<?> v = (Iterable<?>) value;
                List<Object> convertedValue = UnderBar.map(v, (element) -> {
                    if (element instanceof StringMap) {
                        return ((StringMap) element).toMapDeeply();
                    }
                    return element;
                });
                result.put(key, convertedValue);
            }
        });
        return result;
    }

    public <T> T remove(String key) {
        return (T) m.remove(key);
    }

    public DateTime parseDate(String key) {
        return Dates.date(string(key));
    }

    public boolean hasContent(String key) {
        return has(key) && Strings.hasContent((String) m.get(key));
    }

    public Optional<String> stringOptional(String key) {
        String value = (String) dieIfMissingKey(m, key);
        return optional(value);
    }

    public Optional<String> stringish(String key) {
        if (!has(key) || isNull(key)) return optional();
        if (type(key) == Optional.class) return stringMaybe(key);
        if (type(key) != String.class) return optional(m.get(key).toString());
        return optional(string(key));
    }

    public Optional<Long> longish(String key) {
        if (!has(key) || isNull(key)) return optional();
        if (type(key) == Optional.class) return longMaybe(key);
        return optional(long_(key));
    }

    public Optional<DateTime> dateish(String key) {
        if (!has(key) || isNull(key)) return optional();
        if (type(key) == Optional.class) return dateMaybe(key);
        return optional(date(key));
    }

    public Optional<Double> doublish(String key) {
        return (has(key) && !isNull(key)) ? optional(double_(key)) : optional();
    }

    public Optional<Boolean> boolish(String key) {
        return (has(key) && !isNull(key)) ? optional(bool(key)) : optional();
    }

    public Optional<Boolean> booleanOptional(String key) {
        return ofNullable((Boolean) dieIfMissingKey(m, key));
    }

    public StringMap merge(StringMap overrides) {
        return new StringMap(UnderBar.merge(m, overrides.m));
    }

    public String asString(String key) {
        return dieIfMissing(m, key).toString();
    }

    public UUID uuid(String key) {
        return getCast(key, x -> (UUID) x);
    }

    public UUID parseUUID(String key) {
        return UUID.fromString(string(key));
    }

    public Optional<UUID> parseUUIDMaybe(String key) {
        return ofNullable(hasValue(key) ? parseUUID(key) : null);
    }

    public Number number(String key) {
        return getCast(key, x -> (Number) x);
    }

    public String asUrl() {
        return isEmpty()
                ? ""
                : "?" + Strings.join("&", m, (k, v) -> urlEncode(k) + "=" + urlEncode((v == null ? "" : v).toString()));
    }

    public boolean isEmpty() {
        return m.isEmpty();
    }

    public boolean isEmpty(String key) {
        return !hasContent(key);
    }

    public double parseDouble(String key, double default_) {
        return ofNullable((String) m.get(key)).map(Double::parseDouble).orElse(default_);
    }

    public boolean parseBoolean(String key, boolean default_) {
        return ofNullable((String) m.get(key)).map(Boolean::parseBoolean).orElse(default_);
    }

    public boolean isNull(String key) {
        return m.get(key) == null;
    }

    public JSONObject jsonObject(String key) {
        return getCast(key, x -> (JSONObject) x);
    }

    public <T> List<T> getList(String key) {
        return getCast(key, x -> (List<T>) x);
    }

    public StringMap shallowCopy() {
        return new StringMap(m);
    }

    public Optional<DateTime> parseDateMaybe(String key) {
        return stringish(key).map(Dates::date);
    }

    public Set<String> keys() {
        return m.keySet();
    }

    public Class type(String key) {
        return m.get(key).getClass();
    }

    public Optional<UUID> uuidMaybe(String key) {
        return (Optional<UUID>) dieIfMissingKey(m, key);
    }

    public UUID uuidOrNull(String key) {
        return uuidMaybe(key).orElse(null);
    }

    public DateTime parseIsoDateTime(String key) {
        return DateTime.parse(string(key), dateTimeParser());
    }

    public Path path(String key) {
        return Paths.get(string(key));
    }

    public long doubleToLong(String k) {
        return Double.valueOf(double_(k)).longValue();
    }

    public Object object(String k) {
        return getCast(k, o -> o);
    }

}
