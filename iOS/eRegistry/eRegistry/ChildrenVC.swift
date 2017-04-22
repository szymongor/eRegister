//
//  ChildrenVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 20.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class ChildrenVC: UIViewController {

    @IBOutlet weak var tableView: UITableView! {
        didSet {
            let cellNib = UINib(nibName: CELL_ID, bundle: nil)
            tableView.register(cellNib, forCellReuseIdentifier: CELL_ID)
            tableView.delegate = self
            tableView.dataSource = self
            tableView.rowHeight = UITableViewAutomaticDimension
            tableView.estimatedRowHeight = 44.0
            tableView.backgroundColor = Colors.MAIN
        }
    }
    
    let CELL_ID = "ChildrenTVCell"
    
    var children: [Student] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Podopieczni"
        
        downloadData()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func downloadData() {
        children.append(Student(id: 2, name: "Adaś", surname: "Grzyb"))
        children.append(Student(id: 4, name: "Janek", surname: "Grzyb"))
    }

}

extension ChildrenVC: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: CELL_ID, for: indexPath) as? ChildrenTVCell else {
            return UITableViewCell()
        }
        cell.prepare(for: children[indexPath.row])
        cell.selectionStyle = .none
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return children.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let student = children[indexPath.row]
        goToGrades(for: student)
    }
    
    
    private func goToGrades(for student: Student) {
        guard let gradeVC = UINib(nibName: "GradesVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? GradesVC else {
            return
        }
        gradeVC.prepare(for: student)
        navigationController?.pushViewController(gradeVC, animated: true)
    }
    
}
