Code Sponge - "Getting the most of your source code"
# Introduction #

Does your source code lack knowledge? Is it a multiple lined mess that just doesn't make any sense to anyone, even possibly you? If you or one of your employees left work now, would others be able to make sense of it?

Code Sponge is a new technology for your software, clarifying the darkness of programming into an easy to use to read, step by step summary of the content. Just program well and let Code Sponge do the rest.

# Details #

**The Hypotheses**

  * Source Code as Live Documentation
  * Source Code as Communication Channel
  * Source Code as Software Metrics

**The Advantages...**

  * Less risk of miscommunication
  * Faster Communication
  * Knowledge of domain resides in codebase
  * Overhearing (sit together)
  * Code is easier to understand (maintainable, extensible)
  * Healthier code allows team to respond to change

**Very Important**
**Ubiquitous Language and Decoupling**

**u-biq-ui-tous**
  * Adjective: Present, appearing, or found everywhere.
  * Synonyms: omnipresent
    * (dictionary.com)

**UBIQUITOUS LANGUAGE**
  * A language structured around the domain model and used by all team members to connect all the activities of the team with the software.
> > (Excerpted from Domain-Driven Design by Eric Evans)

  * We understand each other.
> > (Excerpted from The Agile Development by James Shore and Shane Warden, Published by O'Reilly. Copyright 2008 the authors. All rights reserved.)


**Coding Examples:**

| **NO** | **YES** |
|:-------|:--------|
| Integer i = new Integer(); |  |
| String char1 = new String() {} | String realMeaningOfMyString=new String(); |
| public class GameDAO() {} | public class ScoreDataLoader(){} |
| catch (Exception e) | catch (Exception NotLoggedInException) |

| **NO** | **YES**|
|:-------|:-------|
| Ambiguities | Clarity |
| Inconsistencies | Precision |
| Synonyms | Reuse |
| Abbreviations | Full Names |


  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages