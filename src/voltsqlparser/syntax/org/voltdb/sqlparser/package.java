/* This file is part of VoltDB.
 * Copyright (C) 2008-2017 VoltDB Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */
/* This file is part of VoltDB.
 * Copyright (C) 2008-2016 VoltDB Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */
/* This file is part of VoltDB.
 * Copyright (C) 2008-2015 VoltDB Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * This is a project to create a complete SQL parser from first
 * principles.  The overall goal is to create a parser which will
 * parse the dialect of SQL which VoltDB uses, and produce VoltXMLElement
 * objects describing it. These VoltXMLElement objects are very
 * stylized XML objects which VoltDB uses to represent SQL ASTs.
 *
 * Our principle is to separate syntax, static semantics, and
 * dynamic semantics one from the other.  It's terribly confusing
 * to mix up all three parts, when they can be clearly separated with
 * a little care from the beginning.  So, the code is separated
 * into four parts.
 * <ol>
 *   <li>The source folder <code>target/generated-sources/antlr4</code>
 *       contains packages to manage the parser.  All code in this
 *       source folder is generated by the Antlr4 tool.  None of
 *       this should be committed to git.  It's not really very instructive
 *       to read this code, but it's possible.</li>
 *   <li>The source folder <code>src/voltsqlparser/syntax<code> contains
 *       the grammar, in the file <code>SQLParser.g4</code>, and definitions
 *       of interfaces which the static semantics and dynamic semantics
 *       layers provide for building data structures to hold the representations
 *       of SQL. The syntax layer really knows nothing about the data structures
 *       except for what the interfaces can do.</li>
 *   <li>The source folder <code>src/voltsqlparser/semantics</code> contains
 *       the implementations of some of the interfaces used by the syntax
 *       layer.  The only interfaces not implemented here are the abstractions
 *       of the actual semantic objects and their creations.  In particular,
 *       the semantics layer knows about the types it creates, but it knows
 *       nothing about Abstract Syntax Trees or VoltXMLElement.  To the
 *       semantics layer, the ASTs are simply objects which implement the
 *       IAST interface, and this is very narrow indeed.</li>
 *   <li>The package <code>org.voltdb.hsqldb_voltpatches</code> contains the
 *       definitions of implementations of <code>VoltParserFactory</code> and
 *       <code>VoltDDLListener.</code>  The former implements the rest of the
 *       factory methods, while the former implements methods called by
 *       methods called by the parser, such as to create ASTs.
 *       <p>
 *       Note that these are probably completely misplaced.
 *       However, they are easily moved.  Since VoltXMLElement is in this HSQLDB
 *       specific package, and these classes are mostly concerned with
 *       VoltXMLElement generation, it's convenient to place them here.
 *   <li>the
 * </ol>
 *
 */
 package org.voltdb.sqlparser;

