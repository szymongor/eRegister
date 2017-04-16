//
//  EducatorVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class EducatorVC: UIViewController {

    @IBOutlet weak var surnameDescLabel: UILabel! {
        didSet {
            surnameDescLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var surnameLabel: UILabel! {
        didSet {
            surnameLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var nameDescLabel: UILabel! {
        didSet {
            nameDescLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var nameLabel: UILabel! {
        didSet {
            nameLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var phoneDescLabel: UILabel! {
        didSet {
            phoneDescLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var phoneLabel: UILabel! {
        didSet {
            phoneLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var emailDescLabel: UILabel! {
        didSet {
            emailDescLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var emailLabel: UILabel! {
        didSet {
            emailLabel.textColor = Colors.MAIN
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Wychowawca"

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    func setView(for educator: Educator) {
        surnameLabel.text = educator.surname
        nameLabel.text = educator.name
        phoneLabel.text = educator.phone
        emailLabel.text = educator.email
    }

}
