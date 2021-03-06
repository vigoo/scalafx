/*
 * Copyright (c) 2011-2014, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.controls.controls

import scalafx.Includes._
import scalafx.scene.control._

/**
 *
 */
class ComboBoxControls(target: ComboBox[String]) extends PropertiesNodes[ComboBox[String]](target, "ComboBox Properties") {

  var itemIndex = 0

  def addNewTab() {
    itemIndex += 1
    target += "Item %d".format(itemIndex)
  }

  def removeCurrentItem() {
    target -= target.value.get
  }

  val txfVisibleRowCount = new TextField {
    text = target.visibleRowCount.get.toString
  }
  txfVisibleRowCount.onAction = handle {  fillIntPropertyFromText(target.visibleRowCount, txfVisibleRowCount, false) }

  val btnAddItem = new Button {
    text = "Add new Item"
    onAction = handle { addNewTab() }
  }

  val btnRemoveItem = new Button {
    text = "Remove Item"
    onAction = handle { removeCurrentItem() }
  }

  super.addNode("Visible Rows", txfVisibleRowCount)
  super.addNodes(btnAddItem, btnRemoveItem)
}
