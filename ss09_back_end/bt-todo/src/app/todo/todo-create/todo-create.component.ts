import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Todo} from '../../model/todo';
import {TodoService} from '../../service/todo.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {


  todoForm: FormGroup = new FormGroup({
    content: new FormControl(),
  });

  constructor(private todoService: TodoService,
              private router: Router) {
  }

  ngOnInit() {
  }

  submit() {
    const todo = this.todoForm.value;
    this.todoService.saveTodo(todo).subscribe(() => {
    this.todoForm.reset();
    alert('Tạo thành công');
    }, e => {
      console.log(e);
    });
    this.router.navigateByUrl('');
  }
}

//
// categoryForm: FormGroup = new FormGroup({
//   name: new FormControl(),
// });
//
// constructor(private categoryService: CategoryService) {
// }
//
// ngOnInit() {
// }
//
// submit() {
//   const category = this.categoryForm.value;
//   this.categoryService.saveCategory(category).subscribe(() => {
//     this.categoryForm.reset();
//     alert('Tạo thành công');
//   }, e => {
//     console.log(e);
//   });
// }
