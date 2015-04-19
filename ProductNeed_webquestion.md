# Do tools exist for pair programming with a developer and a domain expert? #


http://stackoverflow.com/questions/4035288/do-tools-exist-for-pair-programming-with-a-developer-and-a-domain-expert



I would like to know if any tools exist to enable pair programing activities between a developer and non developer expert in the related field.

An example of such a tool could be an IDE plugin that would require a plain language description of functions/methods inline with their arguments. This plugin could then render a section of code as a series of plain language place holders that could be displayed in a seperate frame/window on the page. The developer may see "Account.ItemCollection.AddItem(Item);" but the domain expert could see instead: "Add the Item to the Item's that the Account owns.".

A different way to word this, are there tools that exist that would allow a programer to partner with a domain expert and allow the domain expert to view a simple psudo code style version of the function currently being worked on?

If such tools exist I do not know what category they are labled under. I am having trouble even finding results in google that approximate what I am looking for.

I am not asking about UML or diagraming tools. I am specifically asking about a tool that would help a non developer understand bits and pieces of implemented functions/methods.

plugins ide documentation libraries pair-programming
link|flag
asked Oct 27 at 16:11
wllmsaccnt
5038
You can do it with the documentation. I mean, the non-dev write a comment like javadoc, so in plain text and just have to put a name like public void foo(); and the dev will do it – ykatchou Oct 27 at 16:16