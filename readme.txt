Coding challenge for Enveritas

1. Read in a file that has a representation of the flavor wheel: http://www.scaa.org/chronicle/wp-content/uploads/2016/01/SCAA_FlavorWheel.01.18.15.jpg
2. Accept a 'tasting note' as input, and output an array of strings for any matching flavors

This project is packaged as a standard Java application. The class 'FlavorWheelParser' reads in the flavor wheel and makes an internal representation of the wheel.
The class 'Flavor' handles the representation of individual flavors and the methods to handle the note parsing.

Note that this is not packaged as a Java package. It should be possible to take the two primary classes and turn them into a package.

Unit tests are in 'FlavorTest.java'

Limitations:
Does not handle a 'not' qualifier (e.g. 'not sweet')
Does not handle misspellings (e.g. 'blackbery')
Does not handle plurization (e.g. 'blackberries')
