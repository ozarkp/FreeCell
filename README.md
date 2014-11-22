FreeCell
========

Based on <a href="http://home.wlu.edu/~lambertk/classes/209/projects/Project7.htm">this project</a>, our final work on a FreeCell
GUI game in Java.

Changes as of the initial commit on November 22, 2013 at 1:22am

Lingering issues from previous submissions:
<ul>
<li>Began attempting to move transferFrom to AbstractCell -- this still needs work!</li>
<li>Cleaned up some of the code in AbstractCell (changed AbstractCell to TrueCell in some input instances)</li>
<li>Created AbstractCellPanel class which implements an interface I also wrote, and made appropriate changes in Single and Multi Card Panels to extend that abstract class</li>
</ul>

Current changes accomplished for Project 7 submission as of Nov 22, 2013 at 1:22am
<ul>
<li>Created getCell method for Cell panels (step 1 on project 7)</li>
<li>Created fromPanel instance variable in AppView (step 2)</li>
<li>Created ViewInformer interface (step 3)</li>
<li>Changed AbstractCellPanel constructor to take a ViewInformer (step 3)</li>
<li>Changed panel creators in AppView to input both the TrueCell and ViewInformer (step 4)</li>
<li>Created an instance of AppViewInformer in AppView (step 4)</li>
<li>Created AppViewInformer class which extends that interface in AppView (step 5)</li>
<li>Created panelPressed method inside AppViewinformer -- this is shaky, and still needs work for all the cases (step 5)</li>
<li>Created a PanelListener class in the AbstractCellPanel and attempted to write up the code for its mousePressed method (step 6)</li>
<li>Created instance variables in AbstractCellPanel for a ViewInformer and PanelListener.</li>
</ul>

Currently the following tasks remain:
<ul>
-<li>FreeCellGame needs to have an isOver method to distinguish whether the player has won/lost or if the game is ongoing</li>
-<li>Steps 5 and 6 need much work, especially PanelListener/mousePressed inside AbstractCellPanel</li>
-<li>Our AbstractCell needs work, as we are supposed to refactor it by including the transfer method in the abstract (right now it is
still defined in each cell class too), and we need to add a boolean canTransferFrom which can be a helper method for some of
the logic we have hard-codded into our transfer method</li>
</ul>
