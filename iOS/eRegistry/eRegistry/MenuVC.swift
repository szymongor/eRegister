//
//  MenuVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 11.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class MenuVC: UIViewController, MenuItemDelegate {

    
    @IBOutlet weak var menuView: UIStackView!
    
    @IBOutlet weak var firstItem: MenuItem! {
        didSet {
            firstItem.descriptionLabel.text = "Oceny"
            firstItem.delegate = self
        }
    }
    @IBOutlet weak var secondItem: MenuItem! {
        didSet {
            secondItem.delegate = self
        }
    }
    @IBOutlet weak var thirdItem: MenuItem! {
        didSet {
            thirdItem.delegate = self
        }
    }
    @IBOutlet weak var fourthItem: MenuItem! {
        didSet {
            fourthItem.delegate = self
        }
    }
    @IBOutlet weak var fifthItem: MenuItem! {
        didSet {
            fifthItem.delegate = self
        }
    }
    @IBOutlet weak var sixthItem: MenuItem! {
        didSet {
            sixthItem.delegate = self
        }
    }
    @IBOutlet weak var bottomView: UIView! {
        didSet {
            bottomView.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var userInfoLabel: UILabel! {
        didSet {
            userInfoLabel.textColor = UIColor.white
            userInfoLabel.text = "Zalogowano jako: \(UserDefaultValues.username)"
        }
    }
    @IBOutlet weak var userTypeLabel: UILabel! {
        didSet {
            userTypeLabel.textColor = UIColor.white
            userTypeLabel.text = "Uczeń"
        }
    }
    
    var menuItemModels: [MenuItemModel] = []
    var menuItems: [MenuItem] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController?.isNavigationBarHidden = false
        initMenuItems()
        // Do any additional setup after loading the view.
    }
    
    func initMenuItems() {
        menuItems = [firstItem, secondItem, thirdItem, fourthItem, fifthItem, sixthItem]
        
        menuItemModels.append(MenuItemModel(with: #imageLiteral(resourceName: "logoIcon"), "Oceny"))
        menuItemModels.append(MenuItemModel(with: #imageLiteral(resourceName: "logoIcon"), "Wychowawca"))
        menuItemModels.append(MenuItemModel(with: #imageLiteral(resourceName: "logoIcon"), "Telefon"))
        menuItemModels.append(MenuItemModel(with: #imageLiteral(resourceName: "logoIcon"), "Adres"))
        
        var i = 0
        for menuItem in menuItems {
            if i < menuItemModels.count {
                var model = menuItemModels[i]
                menuItem.setModel(model)
            } else {
                menuItem.isHidden = true
            }
            i += 1
        }
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func onMenuItemClick(sender: MenuItem) {
        switch sender {
        case firstItem:
            print("1")
        case secondItem:
            print("2")
        case thirdItem:
            print("3")
        case fourthItem:
            print("4")
        case fifthItem:
            print("5")
        case sixthItem:
            print("6")
        default:
            break
        }
    }

}
