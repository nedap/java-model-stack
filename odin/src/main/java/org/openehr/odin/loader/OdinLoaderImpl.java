package org.openehr.odin.loader;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017 Cognitive Medical Systems
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 * Author: Claude Nanjo
 */

import org.apache.commons.io.IOUtils;
import org.openehr.odin.antlr.OdinVisitorImpl;
import org.openehr.odin.antlr.odinLexer;
import org.openehr.odin.antlr.odinParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OdinLoaderImpl {

    private static Logger log = LogManager.getLogger(OdinLoaderImpl.class.getName());

    public OdinVisitorImpl loadOdinFile(String bmmFilePath) {
        File file = new File(bmmFilePath);
        OdinVisitorImpl visitor = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            visitor = loadOdinFile(fis);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.error("Error loading reference model", ioe);
            throw new RuntimeException("Error loading reference model", ioe);
        }
        return visitor;
    }

    public OdinVisitorImpl loadOdinFile(InputStream inputStream) {
        OdinVisitorImpl visitor = new OdinVisitorImpl<>();
        try {
            ANTLRInputStream input = new ANTLRInputStream(inputStream);
            odinLexer lexer = new odinLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            odinParser parser = new odinParser(tokens);
            ParseTree tree = parser.odin_text();
            visitor.visit(tree);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.error("Error loading odin file", ioe);
            throw new RuntimeException("Error loading odin file", ioe);
        }
        return visitor;
    }

    public OdinVisitorImpl loadOdinFromString(String odinContent) {
        OdinVisitorImpl visitor = new OdinVisitorImpl<>();
        try {
            InputStream is = IOUtils.toInputStream(odinContent, "UTF-8");
            ANTLRInputStream input = new ANTLRInputStream(is);
            odinLexer lexer = new odinLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            odinParser parser = new odinParser(tokens);
            ParseTree tree = parser.odin_text();
            visitor.visit(tree);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.error("Error loading odin file", ioe);
            throw new RuntimeException("Error loading odin file", ioe);
        }
        return visitor;
    }
}

