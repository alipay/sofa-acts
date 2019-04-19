/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.test.acts.object.comparer.impl;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by yanzhu on 2019/1/15.
 */
public class MapComparerTest {

    @Test
    public void test() {

        MapComparer mapComparer = new MapComparer();
        HashMap<String, String> expect = new HashMap<String, String>();
        expect.put("test", "test");
        expect.put("test1", "test");
        HashMap<String, String> actual = new HashMap<String, String>();
        actual.put("test", "test");
        actual.put("test1", "test");
        Assert.assertTrue(mapComparer.compare(expect, actual, null));

        String act = "{\"test\":\"test\",\"test1\":\"test\"}";

        Assert.assertTrue(mapComparer.compare(expect, act, null));

    }

    @Test
    public void testNullEqualsNull() {
        MapComparer mapComparer = new MapComparer();
        HashMap<String, String> expect = null;
        HashMap<String, String> actual = null;

        Assert.assertTrue(mapComparer.compare(expect, actual, null));
    }

    @Test
    public void testMapNotEqualsNull() {
        MapComparer mapComparer = new MapComparer();
        HashMap<String, String> expect = new HashMap<String, String>();
        expect.put("test", "test");
        expect.put("test1", "test");
        HashMap<String, String> actual = null;

        Assert.assertFalse(mapComparer.compare(expect, actual, null));
    }

    @Test
    public void testStringNotEqualsMap() {
        MapComparer mapComparer = new MapComparer();
        String expect = "";
        HashMap<String, String> actual = new HashMap<String, String>();
        actual.put("test", "test");
        actual.put("test1", "test");

        Assert.assertFalse(mapComparer.compare(expect, actual, null));
    }

    @Test
    public void testMapNotEqualsString() {
        MapComparer mapComparer = new MapComparer();
        HashMap<String, String> expect = new HashMap<String, String>();
        expect.put("test", "test");
        expect.put("test1", "test");
        String actual = "{}";

        Assert.assertFalse(mapComparer.compare(expect, actual, null));
    }

    @Test
    public void testNullNotEqualsString() {
        MapComparer mapComparer = new MapComparer();
        HashMap<String, String> expect = null;
        String actual = "";

        Assert.assertFalse(mapComparer.compare(expect, actual, null));
    }

    @Test
    public void testNotEqualMaps() {
        MapComparer mapComparer = new MapComparer();
        HashMap<String, String> expect = new HashMap<String, String>();
        expect.put("1", "Y");
        expect.put("2", "N");
        HashMap<String, String> actual = new HashMap<String, String>();
        actual.put("1", "test");
        actual.put("2", "test");

        Assert.assertFalse(mapComparer.compare(expect, actual, null));
    }
}
